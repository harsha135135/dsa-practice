# Subnetting

An IPv4 address is 32 bits, written as four numbers from 0 to 255: `10.0.1.25`.

**CIDR notation** `10.0.1.0/24` means "the first 24 bits are the network part; the rest identify
hosts in it". 32 − 24 = 8 host bits, so 2⁸ = 256 addresses: `10.0.1.0` to `10.0.1.255`.

| Prefix | Host bits | Addresses |
|---|---|---|
| `/16` | 16 | 65,536 |
| `/24` | 8 | 256 |
| `/28` | 4 | 16 |
| `/32` | 0 | 1 (a single address) |

**Splitting** a network: `10.0.0.0/16` can be cut into 256 subnets of `/24`
(`10.0.0.0/24`, `10.0.1.0/24`, ...). Each extra prefix bit halves the size.

**Reserved addresses:** normally the first (network) and last (broadcast) address of a subnet are not
usable. **AWS reserves 5** in every subnet (the first four and the last), so a `/24` gives 251 usable addresses.

**Private ranges** (not reachable from the internet directly): `10.0.0.0/8`, `172.16.0.0/12`, `192.168.0.0/16`.

**Where you see it:** seat-reservation B6's Terraform creates a VPC `10.20.0.0/16` and a subnet `10.20.1.0/24`.

## Self-check

1. How many addresses does `/26` contain?
2. Is `10.0.2.7` inside `10.0.0.0/23`?
3. Why can you not use all 256 addresses of a `/24` subnet in AWS?

<details><summary>Answers</summary>

1. 2⁶ = 64.
2. No. `/23` covers `10.0.0.0` to `10.0.1.255`.
3. AWS reserves 5 addresses per subnet (network, router, DNS, future use, broadcast), leaving 251.
</details>
