# Routing

**Routing** decides where a packet goes next. Every machine and router has a **routing table**: a list
of "for destinations in this range, send to that next hop".

```
Destination      Next hop
10.20.0.0/16     local            (stay inside the network)
0.0.0.0/0        internet gateway (everything else)
```

**Longest prefix wins:** a packet to `10.20.1.5` matches both lines, but `/16` is more specific than `/0`,
so it stays local. `0.0.0.0/0` is the **default route**: it matches everything, but loses to any
more specific match.

**A packet's path** is decided hop by hop: each router only knows the next step, not the whole route.
`traceroute example.com` shows the hops.

**In AWS:** a subnet is **public** if its route table sends `0.0.0.0/0` to an **internet gateway**. A
**private** subnet has no such route (it may use a NAT gateway to reach out, but cannot be reached from outside).

**Where you see it:** seat-reservation B6's Terraform has a route table with `0.0.0.0/0 → internet gateway`.

## Self-check

1. A table has `10.0.0.0/8 → A` and `10.1.0.0/16 → B`. Where does `10.1.2.3` go?
2. What makes an AWS subnet "public"?
3. What does the default route do?

<details><summary>Answers</summary>

1. B: `/16` is the longer (more specific) matching prefix.
2. Its route table sends `0.0.0.0/0` to an internet gateway.
3. It catches every destination that no more specific route matches.
</details>
