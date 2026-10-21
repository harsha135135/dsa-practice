# TCP vs UDP

Both carry data between programs over IP, identified by **ports** (HTTP usually uses port 80, HTTPS 443).

| | TCP | UDP |
|---|---|---|
| Connection | yes: a handshake first (SYN, SYN-ACK, ACK) | no: just send |
| Delivery | guaranteed, or you get an error | may be lost, silently |
| Order | bytes arrive in the order sent | packets may arrive out of order |
| Shape of data | a **stream of bytes** with no message boundaries | separate **datagrams** |
| Typical use | HTTP, SSH, databases | DNS lookups, video calls, games |

**The important TCP detail for the HTTP server project:** TCP is a byte **stream**. One `read()` can return
half a request, or one and a half requests. The receiver must find message boundaries itself; HTTP does this
with blank lines and `Content-Length`.

**Why UDP at all:** no handshake and no waiting for lost packets to be resent. For a live call, a late packet
is useless anyway; for a DNS lookup, it is cheaper to just ask again.

**Where you see it:** java-http-server reads requests that arrive in pieces; `ss -tlnp` lists TCP listening
sockets on Linux.

## Self-check

1. A client sends 100 bytes in one `write()`. Will the server's `read()` always return all 100?
2. What do SYN, SYN-ACK and ACK set up?
3. Why does DNS usually use UDP?

<details><summary>Answers</summary>

1. No. TCP may deliver them in several pieces; the server must keep reading until it has the whole message.
2. A TCP connection: both sides agree on starting sequence numbers and confirm they can reach each other.
3. A query and its answer are tiny and fit in one packet, and resending a lost query is cheaper than a handshake.
</details>
