# DNS and DNS caching

**DNS** turns a name (`seats.example.com`) into an address (`203.0.113.10`), like a phone book.

**A lookup, step by step** (when nothing is cached):
1. Your computer asks a **resolver** (from your ISP, your router, or `1.1.1.1`).
2. The resolver asks a **root** server: "who handles `.com`?"
3. It asks the **`.com`** servers: "who handles `example.com`?"
4. It asks **example.com's own name servers**, which return the **A record**: `203.0.113.10`.

**Caching:** every answer carries a **TTL** (time to live), in seconds. The resolver, and often your OS and
browser, keep the answer that long. Repeat lookups are then instant and do not reach the name servers.

**The catch:** after you change a record, old answers stay cached until their TTL runs out. Lower the TTL
(for example to 60 seconds) **before** a planned change.

**Record types:** `A` (IPv4 address), `AAAA` (IPv6), `CNAME` (alias to another name), `MX` (mail), `TXT` (text, used for verification).

**Where you see it:** seat-reservation B6: you create an A record pointing at the server's Elastic IP;
`dig seats.example.com` shows the answer and its remaining TTL.

## Self-check

1. You changed an A record an hour ago, but some users still reach the old server. Why?
2. What does `dig` show next to each answer?
3. Why is DNS caching good for the name servers?

<details><summary>Answers</summary>

1. Their resolvers cached the old answer and its TTL has not run out yet.
2. The TTL: the seconds left before that cached answer expires.
3. Most lookups are answered from caches, so the name servers get far fewer requests.
</details>
