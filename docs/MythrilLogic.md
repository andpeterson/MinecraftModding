# Mythril Logic
## Goal
After mining mythril ore you will have an hour to use the gems before they run out of power (or become weaker)
## Thoughts
 - When the gems are stored in a stack I can't keep track of them indicidually so I'll have to avg as you move stacks around (I might have to extend ItemStack?)
 - When you craft something, all the mythril in the recipe will avg their times
 - I'll need to store a variable on any mythril stacks, and mythril items crafted to store this info
 - On ever tick I can re-calculate the timers on the mythril
 - I might have to use Capabilities that are attached to an itemStack