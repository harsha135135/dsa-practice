# Virtual memory

Every process sees memory as one big private range of addresses, starting near 0. These are
**virtual addresses**. The CPU and the operating system translate them to **physical** addresses
(real RAM) using **page tables**, in chunks called **pages** (often 4 KiB).

**What this gives you:**
- **Isolation:** process A's address 1000 and process B's address 1000 are different RAM. A cannot touch B.
- **Only what is used takes RAM:** a page gets real RAM the first time it is touched. A process can reserve
  far more than it uses.
- **Swapping:** rarely used pages can be moved to disk and brought back when needed (slow).
- **Sharing:** the same library code can be mapped into many processes but stored once.

**Page fault:** the program touched a page that is not in RAM right now. The OS loads or creates it,
then the program continues. Many page faults from disk make a program slow.

**Where you see it:** `top` shows **VIRT** (all reserved addresses) and **RES** (actually in RAM). A JVM's
VIRT is often far larger than RES.

## Self-check

1. Two processes both print the address of a variable and get the same number. Do they share it?
2. Why can VIRT be much bigger than the machine's RAM?
3. What happens on a page fault for a page that was swapped to disk?

<details><summary>Answers</summary>

1. No. It is the same *virtual* address, but each process's page table maps it to different physical memory.
2. Reserving address space costs no RAM; only touched pages get RAM.
3. The OS pauses the process, reads the page from disk into RAM, updates the page table, and resumes it.
</details>
