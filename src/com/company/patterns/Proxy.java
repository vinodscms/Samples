package com.company.patterns;

import java.util.ArrayList;
import java.util.List;


/**
 * Proxy object which stands for another object. Ex. Remote/client proxy for a server object. The remote object can do
 * some marshalling or some operations and internally connect to the server side. Another ex is for security proxy which
 * can be used to add some security features. Like a college network
 */
public class Proxy {
    public static void main (String[] args)
    {
        Internet internet = new ProxyInternet();
        try
        {
            internet.connectTo("sears.com");
            internet.connectTo("abcd.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

interface Internet
{
    public void connectTo(String host) throws Exception;
}



class RealInternet implements Internet
{
    @Override
    public void connectTo(String host)
    {
        System.out.println("Redirecting to "+ host);
    }
}

class ProxyInternet implements Internet
{
    private Internet internet = new RealInternet();
    private static List<String> blockedSites;

    static
    {
        blockedSites = new ArrayList<>();
        blockedSites.add("abcd.com");
        blockedSites.add("def.com");
    }

    @Override
    public void connectTo(String host) throws Exception
    {
        if(blockedSites.contains(host.toLowerCase()))
        {
            throw new Exception("Site blocked");
        }

        internet.connectTo(host);
    }

}


