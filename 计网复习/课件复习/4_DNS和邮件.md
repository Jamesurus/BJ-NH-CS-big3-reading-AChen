# DNS

administrators need to update host file on a regular basis, or not the maps will grow out of date, there may be some name collisions.

# hosts.txt

not suited to Internet scale

No trigger for updates, when IP addresses are changed

become the target of the malware, which may change the map then user is directed to dangerous sites.

# Domain Name System

1. distributed database implemented in hierarchy of many servers.

2. application-layer protocol, hosts, name servers communicate to resolve names

   Runs over UDP uses port number 53

DNS system translates hostnames to their underlying Ip address

# Why not centralized DNS?

a centralized database in a single DNS server simply doesn't scale.不可扩展

distributed, hierarchical database

subdomain

a part of another domain. scc.lancas.ac.uk is a subdomain of lancas.ac.uk, which is sub-domain of ac.uk

Fully Qualified Domain Names(FQDN)

absolute domain name

en.wikipedia.org.

[local hostname].[second level domain].[tld].[root label(empty)]

TLD

Top Level Domain

# DNS Root name servers

root name servers provide the IP addresses of the TLD servers.

13 logical root name servers worldwide

incredibly important Internet function

ICANN manages root DNS domain

## logical name like

a-m.root-servers.net

# why only 13 root name servers logically?

original DNS specification, it specifies a maximum packet size of 512 bytes when using UDP, all IP addresses for root servers should fit into one single packet,

要让所有的根服务器数据能包含在一个512字节的UDP包中,根服务器只能限制在13个

## Local DNS name servers

each ISP has one, also called "default name server"

host makes DNS query, query is sent to local DNS server

root, TLD, authoritative DNS servers all belong to the hierarchy of DNS servers.

# How does DNS works?

## Iterative query-迭代查询

contacted server replies with name of server that host need to contact next

Situation: 我不知道,你问问他

## Recursive query-递归查询

burden on contacted name

Situation:我虽然不知道,我给你问问哈

in fact, query from requesting host to local DNS server is recursive, remaining queries are iterative

Caching, updating DNS records

name server learns mapping, caches mapping

also, entries grow out of date after some time

TLD servers typically cached in local name servers, that's why root name servers not often visited

host changes IP address, may not be known Internet-wide until all TTLs expire

# DNS records

distributed database storing resource records(RR)

RR format: name, value, type, ttl

the TTL determines when a resource should be removed from cache

## type explanation of DNS records

### A

host name, value is IP address

### NS

domain, value is host name of authoritative name server for this domain

### CNAME

value is "canonical" real name for the alias hostname name

### MX

canonical name of a mail server that has an alias hostname

# DNS records and messages

DNS format, query and reply messages have same format.

## identification

16 bits identify the query, copied into the replay message, allowing client to match received replies with sent queries

## flag

1. query of reply
2. recursion desired
3. recursion available
4. replay is authoritative

资源记录,resource record,提供了主机名到IP地址的映射

# DNS Security

Distributed denial-of-service attacks-分布式拒绝服务

Solution

DNSSEC

Domain Name System Security Extensions

# Email

three major components:

user agents, mail server, communication ptotocls

transmission protocol: SMTP-simple mail ==transfer== protocol

mail management protocols:

POP3-post office protocol 3

, IMAP Internet mail access protocol

# SMTP some archaic characters

body uses simple 7 bit ASCII

binary multimedia data has to be encoded to ASCII before sending

underlying transport layer protocol: TCP

port 25

transfer 3 phases:

handshaking, transfer, colsure

command/response interaction

client: ASCII text

response: status code

在邮件传输中,没有中间邮箱服务器, intermediate mail servers,都是直接连接

SMTP 使用CRLF决定消息的结束

CR carriage return

LF line feed

![1640834458(1)](D:\Typora\图片\1640834458(1).png)

retrieve-取回

web-based Mail Access Protocls, web browser serve as user agent

POP3下载即删除,或者下载仍保留两种模式

IMAP可管理邮箱服务器上的邮件
