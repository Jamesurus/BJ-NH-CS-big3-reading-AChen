## ARP:

knowing its IP address, how to determine interface's MAC address?

根据ARP表，包括mappings对于一些局域网节点

<IP address; MAC address; TTL>

## TTL:

time after which address mapping will be forgotten.

所有有网卡的设备都有一个MAC地址：

12位16进制数

子网掩码

## MAC:

MAC地址: media access control--identify device in local network

(LAN / physical / Ethernet address)

function：

in same subnet, locally used to get frame from one interface to another interface.

6个8位2进制数，48位MAC地址

当我需要在其他地方接入网络时，不需要更换网卡，只需要获取一个新的IP地址

数据包在这些节点之间的移动都是由ARP（Address Resolution Protocol：地址解析协议）负责将IP地址映射到MAC地址上来完成的。

IP地址好比住址的门牌号，住在不同的地方就有不同的门牌号，

MAC地址好比身份证号码，一出生就有的且不会发生改变。但是知道身份证号码是无法找到你的，身份证号码和地理位置无关。

## CSMA: carrier sense multiple access

每站在发送数据之前检测总线上是否有其他计算机在发送数据

1. simple CSMA: listen before transmit:;

   channel sensed idle(空): transmit entire frame

   busy: defer transmission

   对比aloha scheme, 略有提升

   

2. CSMA/CD with collision detection

sense collision by sending a frame, if collision, abort immediately.（马上停止）

<font color =  red>perform exponential backoff</font>

## pure ALOHA

unslotted Aloha: no synchronization

## slotted ALOHA:

all frames same size, time divided into equal size, nodes start to transmit only slot beginning

在放入下一个时隙之前先检测，若collision,

node retransmits frame with probability p until success

### performance

N nodes with many frames, a given node has success in a slot: p(1-p)^N-1

max efficiency: find p*, 你设置一个概率，Np(1-p)^N-1最大

37%

## Random access protocols:

1. how to detect collisions
2. how to recover from collisions

ALOHA, slotted ALOHA, CSMA, CSMA/CD, CSMA/CA

## cyclic redundancy check(CRC):

Cyclic Redundancy Check(Polynomial code)

发送方与接收方协商一r+1比特模式，成为生成多项式(generator)

对于给定的数据段D，发送方选择r个附加比特R，将其附加到D上，使得到的d+r模式用模2运算恰好可以被整除，运算方法为，先计算出余数，把余数加到原来数据，则再除就没余数

G是多项式位数r，CRC bits r-1

1. append r-1 bits of 0 at the end of data D
2. divide padded data using modulo-2 arithmetic
3. finally, 3-bits long remainder is the CRC bits will be appended to the data bits at the sender side before the transimission.

error detection, correction

`打包成帧(framing)`: 在每个网络层数据报在传输之前，几乎所有的链路层协议都会将数据报用链路层封装起来。数据链路层从网络层获取数据后将其封装成为 `帧`，如果帧太大的话，数据链路层会将大帧拆分为一个个的小帧，小帧能够使传输控制和错误检测更加高效

## 奇偶校验位

![image-20211217103811552](E:\typorapro\图片\image-20211217103811552.png)

一维的奇偶校验只能检错，二维的可以定位进而纠错

二维就是d个比特被划分为i行J列， two dimensional parity

## IP fragmentation / reassembly

MTU(max transmission unit)

## CIDR

无类别域间路由?

## NAT network address translation

local network uses just one IP address as far as outside concerned.

在外界看来,一个局域网用一个IP地址,

![image-20211217113143257](E:\typorapro\图片\image-20211217113143257.png)

## Network-layer function

forwarding-data layer

routing-control layer

2 approaches to struct network:

1. per-router control

2. logically centralized control

## Dijkstra's link-state routing

compute least cost paths from one node to all other nodes

## Distance vector algorithm

![image-20211217120842872](E:\typorapro\图片\image-20211217120842872.png)

## Intra-AS 

### OSPF(open shortest path first)

each router floods OSPF link-state advertisements(directly over IP rather than using TCP/UDP) to all other routers in entire AS.

each router has full topology, uses Dijkstra's algorithm to compute forwarding table.

确保安全的,all OSPF messages authenticated(防止恶意攻击,malicious instrusion)

## and Inter-AS

BGP(Boder Gateway Protocol)

decentralized, based on distance vector algorithm.

eBGP: obtain subnet reachability information from neighboring ASes

iBGP:propagate reachability information to all AS-internal routers.

## Transport services and protocols

logical communication between application processes running on different hosts.

Transport protocols implemented in end system, 

sender: breaks application messages into segments, pass them to network layer.

receiver: reassembles segments into messages, passes to application layer.

TCP UDP都是传输层协议.

TCP: Transmission Control Protocol

reliable, in-order, congestion and flow control, 

UDP: user datagram protocol

unreliable, unordered, no-frills extension(不加修饰),best effort

## UDP checksum

sender: treat contents of UDP segment as sequence of 16-bit integers

do addition

receiver: addition again, 

## TCP advantages

1. point to point

2. reliable, in-order byte steam

3. connection-oriented

   ​	handshake, initialize sender, receiver state before data exchange.

4. full duplex(全双工)

5. cumulative ACKs

6. pipelining

7. flow controlled

## TCP fast retransmit

sender receives triple duplicate ACKs, resend unACKed segment with smallest seq#???

TCP congestion control

receiver controls sender, sender won't overflow receiver's buffer

## TCP congestion control

**Principles** of congestion control: too many sources sending too much data too fast for *network* to handle

manifestations: 

1. long delay
2. packet loss

### 3 scenarios of congestion control

![屏幕截图(1)](C:\Users\ws\Pictures\Screenshots\屏幕截图(1).png)

#### scenario_1

2发送端,2接收端,RBps,增加到链路带宽R/2时,无法增加,越接近带宽,排队越长

![image-20211220135956408](C:\Users\ws\AppData\Roaming\Typora\typora-user-images\image-20211220135956408.png)

1. *Large queuing delays are experienced **as the packet-arrival rate nears the link capacity.***  

   两个主机,高速公路无限长,但是收费站得一个一个来收费,车太多了,就堵车了.

![image-20211220112639019](C:\Users\ws\AppData\Roaming\Typora\typora-user-images\image-20211220112639019.png)

senders increase window size until packet loss occurs.

Additive increase multiplicative decrease

#### scenario_2

![image-20211220133135789](C:\Users\ws\AppData\Roaming\Typora\typora-user-images\image-20211220133135789.png)


$$
\lambda'in
$$
包括了需要重传的,所以,原本传输一定量的数据,此时需要从发送端发送更多数据才能达到原来的效果

没重力,水管指哪打哪,如果重力加速度太大,需要使更大的劲

网络需要发送很多没有必要重传的分组,因为它们在拥塞,还在路上

#### scenario_3

![image-20211220140850983](C:\Users\ws\AppData\Roaming\Typora\typora-user-images\image-20211220140850983.png)

## Difference bwtween Tahoe and Reno when 3 duplicate ACKs

![image-20211220110856870](C:\Users\ws\AppData\Roaming\Typora\typora-user-images\image-20211220110856870.png)

slow start thresh都变为原来的1/2,但是cwnd,congestion window大小不同,

## 2 different TCP modes of congestion control

### TCP Tahoe:

ssthresh-1/2 cwnd

<font color=red>cwnd-1MSS</font>

### TCP Reno:

ssthresh-1/2 cwnd

<font color=red>cwnd-ssthresh+3*MSS</font>

timeout event相同,cwnd-1MSS,ssthresh-1/2 cwnd

## ECN

Explicit congestion notification(ECN)

two bits in IP header to indicate congestion

问过来的车来的路上堵不堵

# Network layer

IPV4 datagram format

IPV4 addressing

IPV6

DHCP

NAT

## what's inside a router?

input ports, switching, output ports, buffer management, scheduling

# RTT

end-to-end delay measured in both directions, no relations to the route.

# IXP

Internet eXchange Point

transfer

SMTP: simple mail transfer protocol

HTTP: hypertext transfer protocol

## DHCP dynamci host configuration protocol

return not only IP address

also 

1. first hop router's IP address
2. local DNS server
3. network mask

status code 1st line in server-client response message

200-OK

301-move permanently, object moved, new location specified later in this message

400-bad request request msg, server doesn't understand

404 not found

505-HTTP version not supported

