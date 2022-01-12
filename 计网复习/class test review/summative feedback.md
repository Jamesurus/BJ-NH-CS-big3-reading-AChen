1. 注意在TCP/IP栈各层名字是专有名词，不可有误
2. link utilization.
3. 是有13个logical root servers, 注意不是13个physical servers.
4. a-m.root-servers.net

why 13 logical root-servers?

使用UDP，每个包最大容量 512 bytes, 每个IPV4占32bytes，

根服务器的所有IP地址应包含在一个数据包中，以避免发送多个信息的开销。

512/32 = 13..96 bytes

demux脱机