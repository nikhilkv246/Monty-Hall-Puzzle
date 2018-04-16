package net.floodlightcontroller.packetclassifier;

import java.util.Collection;
import java.util.Map;

import org.projectfloodlight.openflow.protocol.OFMessage;
import org.projectfloodlight.openflow.protocol.OFType; 
import org.projectfloodlight.openflow.types.MacAddress;

import net.floodlightcontroller.core.FloodlightContext;
import net.floodlightcontroller.core.IOFMessageListener;
import net.floodlightcontroller.core.IOFSwitch;
import net.floodlightcontroller.core.module.FloodlightModuleContext;
import net.floodlightcontroller.core.module.FloodlightModuleException;
import net.floodlightcontroller.core.module.IFloodlightModule;
import net.floodlightcontroller.core.module.IFloodlightService;

public class packetclassifier implements IOFMessageListener, IFloodlightModule {
@Override
public String getName() {
    return packetclassifier.class.getSimpleName();
}

@Override
     public boolean isCallbackOrderingPrereq(OFType type, String name) {
         // TODO Auto-generated method stub         
return false;
}

@Override
     public boolean isCallbackOrderingPostreq(OFType type, String name) { 
     // TODO Auto-generated method stub         
return false;     
}

@Override
     public Collection<Class<? extends IFloodlightService>> getModuleServices() {
         // TODO Auto-generated method stub
         return null;     
}

@Override     public Map<Class<? extends IFloodlightService>, IFloodlightService> getServiceImpls() {
         // TODO Auto-generated method stub
         
return null;    
}

@Override     public Collection<Class<? extends IFloodlightService>> getModuleDependencies() {
         // TODO Auto-generated method stub         
return null;     
}

@Override    public net.floodlightcontroller.core.IListener.Command receive(IOFSwitch sw, OFMessage msg, FloodlightContext cntx) 
{
/* Retrieve the deserialized packet in message */
Ethernet eth = IFloodlightProviderService.bcStore.get(cntx, IFloodlightProviderService.CONTEXT_PI_PAYLOAD);

/* Various getters and setters are exposed in Ethernet */
MacAddress srcMac = eth.getSourceMACAddress();
VlanVid vlanId = VlanVid.ofVlan(eth.getVlanID());

/* Check the ethertype of the Ethernet frame and retrieve the appropriate payload. */
if (eth.getEtherType() == EthType.IPv4) {
/* We got an IPv4 packet; get the payload from Ethernet */            
IPv4 ipv4 = (IPv4) eth.getPayload();

/* Various getters and setters are exposed in IPv4 */
byte[] ipOptions = ipv4.getOptions();             
IPv4Address dstIp = ipv4.getDestinationAddress();

/*               * Check the IP protocol version of the IPv4 packet's payload.              */
if (ipv4.getProtocol() == IpProtocol.TCP) {
/* We got a TCP packet; get the payload from IPv4 */
TCP tcp = (TCP) ipv4.getPayload();
TransportPort srcPort = tcp.getSourcePort();
TransportPort dstPort = tcp.getDestinationPort();
short flags = tcp.getFlags();

if(srcPort == 80 || dstPort == 80)
logger.info("HTTPS Traffic arriving}")  //Instantiate HTTPS Click


if(srcPort == 5672 || dstPort == 5672)
logger.info("AMQP Traffic arriving}")  //Instantiate AMQP Click
}

else if (ipv4.getProtocol() == IpProtocol.UDP) {
/* We got a UDP packet; get the payload from IPv4 */                 
UDP udp = (UDP) ipv4.getPayload();

/* Various getters and setters are exposed in UDP */                 
TransportPort srcPort = udp.getSourcePort();
TransportPort dstPort = udp.getDestinationPort();

if(srcPort == 53 || dstPort == 53)
logger.info("DNS Traffic arriving}")


if(srcPort == 68 || dstPort == 67)
logger.info("DHCP Traffic arriving}")



if(srcPort == 5672 || dstPort == 5672)
logger.info("AMQP Traffic arriving}")  //Instantiate AMQP Click






}
}
