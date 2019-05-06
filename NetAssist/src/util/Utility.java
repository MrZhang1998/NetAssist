package util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Utility
{
	// 获得本地所有网卡的ip
	public static  List<String> getNetworkAddress()
	{
		List<String> result = new ArrayList<String>();
		Enumeration<NetworkInterface> netInterfaces;
		try
		{
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip;
			while (netInterfaces.hasMoreElements())
			{
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> addresses = ni.getInetAddresses();
				while (addresses.hasMoreElements())
				{
					ip = addresses.nextElement();
					if (ip.getHostAddress().indexOf(':') == -1)
					{
						result.add(ip.getHostAddress());
					}
				}
			}
			
			return result;
		} catch (Exception e)
		{
			return null;
		}
	}
}
