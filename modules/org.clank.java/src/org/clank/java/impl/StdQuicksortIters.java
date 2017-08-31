/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clank.java.impl;

import org.clank.support.aliases.*;
import java.util.Comparator;
import org.clank.java.std;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.NativeTrace;

/**
 *
 * @author petrk
 */
public class StdQuicksortIters {
  
  public static <T, Iter extends type$iterator<Iter, T>> void _stablesort(Iter pbase, int total_elems, Comparator<T> cmp) {
    if (total_elems > MAX_THRESH) {
      NativeTrace.traceNotImplemented("not completely implemented StdQuicksortIters._stablesort");
    }
    _quicksort(pbase, total_elems, cmp);
  }
  
/* Order size using quicksort. This implementation incorporates
   four optimizations discussed in Sedgewick:

   1. Non-recursive, using an explicit stack of pointer that store the
   next array partition to sort. To save time, this maximum amount
   of space required to store an array of SIZE_MAX is allocated on the
   stack. Assuming a 32-bit (64 bit) integer for size_t, this needs
   only 32 * sizeof(stack_node) == 256 bytes (for 64 bit: 1024 bytes).
   Pretty cheap, actually.

   2. Chose the pivot element using a median-of-three decision tree.
   This reduces the probability of selecting a bad pivot value and
   eliminates certain extraneous comparisons.

   3. Only quicksorts TOTAL_ELEMS / MAX_THRESH partitions, leaving
   insertion sort to order the MAX_THRESH items within each partition.
   This is a big win, since insertion sort is faster for small, mostly
   sorted array segments.

   4. The larger of the two sub-partitions is always pushed onto the
   stack first, with the algorithm then concentrating on the
   smaller partition. This *guarantees* no more than log (total_elems)
   stack size is needed (actually O(1) in this case)! */
  
  public static <T, Iter extends type$iterator<Iter, T>> void _quicksort(Iter pbase, int total_elems, Comparator<T> cmp) {
    if (total_elems <= 1)
      /* Avoid lossage with unsigned arithmetic below. */
      return;
    
    Iter base_ptr = $tryClone(pbase);

    final int max_thresh = MAX_THRESH;

    if (total_elems > MAX_THRESH) {
      Iter lo = $tryClone(base_ptr);
      Iter hi = lo.$add(total_elems - 1);
      stack_node<T, Iter> stack[] = createStack();
      type$ptr<stack_node<T, Iter>> top = create_type$ptr(stack);

      PUSH(top, null, null);

      while (STACK_NOT_EMPTY(stack, top)) {
        Iter left_ptr;
        Iter right_ptr;

        /* Select median value from among LO, MID, and HI. Rearrange
        LO and HI so the three values are sorted. This lowers the
        probability of picking a pathological pivot value and
        skips a comparison for both the LEFT_PTR and RIGHT_PTR in
        the while loops. */

        Iter mid = lo.$add((hi.$sub(lo)) >>> 1);

        boolean jump_over = false;
        
        if (cmp.compare(mid.$star(), lo.$star()) < 0)
          SWAP(mid, lo);
        if (cmp.compare(hi.$star(), mid.$star()) < 0)
          SWAP(mid, hi);
        else
          jump_over = true;
        
        if (!jump_over) {
          if (cmp.compare(mid.$star(), lo.$star()) < 0)
            SWAP(mid, lo);
        }        

        left_ptr = lo.$add(1);
        right_ptr = hi.$sub(1);

        /* Here's the famous ``collapse the walls'' section of quicksort.
        Gotta like those tight inner loops! They are the main reason
        that this algorithm runs much faster than others. */
        do {
          while (cmp.compare(left_ptr.$star(), mid.$star()) < 0)
            left_ptr.$inc(1);

          while (cmp.compare(mid.$star(), right_ptr.$star()) < 0)
            right_ptr.$dec(1);

          if ($less(left_ptr, right_ptr)) {
            SWAP(left_ptr, right_ptr);
            if (mid.$eq(left_ptr))
              mid = $tryClone(right_ptr);
            else if (mid.$eq(right_ptr))
              mid = $tryClone(left_ptr);
            left_ptr.$inc(1);
            right_ptr.$dec(1);
          } else if (left_ptr.$eq(right_ptr)) {
            left_ptr.$inc(1);
            right_ptr.$dec(1);
            break;
          }
        } while ($lesseq(left_ptr, right_ptr));

        /* Set up pointers for next iteration. First determine whether
        left and right partitions are below the threshold size. If so,
        ignore one or both. Otherwise, push the larger partition's
        bounds on the stack and continue sorting the smaller one. */

        if (right_ptr.$sub(lo) <= max_thresh) {
          if ((hi.$sub(left_ptr)) <= max_thresh)
            /* Ignore both small partitions. */
            POP(top, lo, hi);
          else
            /* Ignore small left partition. */
            lo = $tryAssign(lo, left_ptr, false);
        } else if ((hi.$sub(left_ptr)) <= max_thresh)
          /* Ignore small right partition. */
          hi = $tryAssign(hi, right_ptr, false);
        else if ((right_ptr.$sub(lo)) > (hi.$sub(left_ptr))) {
          /* Push larger left partition indices. */
          PUSH(top, lo, right_ptr);
          lo = $tryAssign(lo, left_ptr, false);
        } else {
          /* Push larger right partition indices. */
          PUSH(top, left_ptr, hi);
          hi = $tryAssign(hi, right_ptr, false);
        }
      }
    }

    /* Once the BASE_PTR array is partially sorted by quicksort the rest
    is completely sorted using insertion sort, since this is efficient
    for partitions below MAX_THRESH size. BASE_PTR points to the beginning
    of the array to sort, and END_PTR points at the very last element in
    the array (*not* one beyond it!). */

    {
      Iter end_ptr = base_ptr.$add(total_elems - 1);
      Iter tmp_ptr = $tryClone(base_ptr);
      Iter thresh = $tryClone(min(end_ptr, base_ptr.$add(max_thresh)));
      Iter run_ptr;

      /* Find smallest element in first threshold and place it at the
      array's beginning. This is the smallest array element,
      and the operation speeds up insertion sort's inner loop. */

      for (run_ptr = tmp_ptr.$add(1); $lesseq(run_ptr, thresh); run_ptr.$preInc())
        if (cmp.compare(run_ptr.$star(), tmp_ptr.$star()) < 0)
          tmp_ptr = $tryClone(run_ptr);

      if (tmp_ptr.$noteq(base_ptr))
        SWAP(tmp_ptr, base_ptr);

      /* Insertion sort, running from left-hand-side up to right-hand-side. */

      run_ptr = base_ptr.$add(1);
      while ($lesseq((run_ptr.$inc(1)), end_ptr)) {
        tmp_ptr = run_ptr.$sub(1);
        while (cmp.compare(run_ptr.$star(), tmp_ptr.$star()) < 0)
          tmp_ptr.$dec(1);

        tmp_ptr.$inc(1);
        if (tmp_ptr.$noteq(run_ptr)) {
          Iter trav;

          trav = run_ptr.$add(1);
          while ($greatereq(trav.$preDec(), run_ptr)) {
            T c = trav.$star();
            Iter hi, lo;

            for (hi = $tryClone(lo = $tryClone(trav)); $greatereq((lo.$preDec()), tmp_ptr); hi = $tryClone(lo))
              hi.star$ref().$set(lo.$star());
            hi.star$ref().$set(c);
          }
        }
      }
    }
  }  

  private static <T, Iter extends type$iterator<Iter, T>> stack_node<T, Iter>[] createStack() {
    stack_node<T, Iter>[] stack = new stack_node[(int) STACK_SIZE];
    for (int i = 0; i < stack.length; ++i) {
      stack[i] = new stack_node<>();
    }
    return stack;
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> boolean $less(Iter lhs, Iter rhs) {
    int diff = lhs.$sub(rhs);
    return diff < 0;
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> boolean $lesseq(Iter lhs, Iter rhs) {
    int diff = lhs.$sub(rhs);
    return diff <= 0;
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> boolean $greatereq(Iter lhs, Iter rhs) {
    int diff = lhs.$sub(rhs);
    return diff >= 0;
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> Iter min(Iter x, Iter y) {
    return $less(x, y) ? x : y;
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> void SWAP(Iter left, Iter right) {
    left.swap(right);
  }
  
  /* Discontinue quicksort algorithm when partition gets below this size.
     This particular magic number was chosen to work best on a Sun 4/260. */
  private static final int MAX_THRESH = 4;
  
  /* Stack node declarations used to store unfulfilled partition obligations. */
  private static class stack_node<T, Iter extends type$iterator<Iter, T>> {
    Iter lo;
    Iter hi;
  };
  
/* The next 4 #defines implement a very fast in-line stack abstraction. */
/* The stack needs log (total_elements) entries (we could even subtract
   log(MAX_THRESH)). Since total_elements has type size_t, we get as
   upper bound for log (total_elements):
   bits per byte (CHAR_BIT) * sizeof(size_t). */
  private static long STACK_SIZE = Long.SIZE;
  
  private static <T, Iter extends type$iterator<Iter, T>> void PUSH(type$ptr<stack_node<T, Iter>> top, Iter low, Iter high) {
    top.$star().lo = $tryClone(low);
    top.$star().hi = $tryClone(high); 
    top.$preInc();
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> void POP(type$ptr<stack_node<T, Iter>> top, Iter low, Iter high) {
    top.$preDec();
    if (top.$star().lo != null && top.$star().hi != null) {
      $tryAssign(low, top.$star().lo, false);
      $tryAssign(high, top.$star().hi, false);
    } else {
      assert top.$index() == 0;
    }
  }
  
  private static <T, Iter extends type$iterator<Iter, T>> boolean STACK_NOT_EMPTY(stack_node<T, Iter> stack[], type$ptr<stack_node<T, Iter>> top) {
    return create_type$ptr(stack).$noteq(top);
  }     
}
