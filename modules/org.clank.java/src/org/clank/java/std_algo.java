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

package org.clank.java;

import java.util.Scanner;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.clank.support.aliases.*;
import static org.clank.java.built_in.*;
import org.clank.java.io.FILE;
import static org.clank.java.io.fgets;
import static org.clank.java.std.isdigit;
import static org.clank.java.std.isspace;
import static org.clank.java.std.strchr;
import static org.clank.java.std.strcspn;
import static org.clank.java.std.strncpy;
import static org.clank.support.literal_constants.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.sizeof;
import org.clank.support.Unsigned;
import static org.clank.support.Unsigned.*;

/**
 *
 * @author petrk
 */
public class std_algo extends std_getopt {
  
  /* Convert a string to a floating-point number.  */
  // extern double atof (const char *__nptr)
  public static double atof(char$ptr str) {
    // TODO: what about NAN and INF?
    Scanner scanner = new Scanner(Native.$toString(str));
    if (scanner.hasNextDouble()) {
      return scanner.nextDouble();
    }
    return 0.0;
  }
  
  /* Convert a string to an integer.  */
  // extern int atoi (const char *__nptr)
  public static int atoi(char$ptr str) {
    Scanner scanner = new Scanner(Native.$toString(str));
    if (scanner.hasNextInt()) {
      return scanner.nextInt();
    }
    return 0;
  }
  
  /* Convert a string to a long integer.  */
  // extern long int atol (const char *__nptr)
  public static long atol(char$ptr str) {
    Scanner scanner = new Scanner(Native.$toString(str));
    if (scanner.hasNextLong()) {
      return scanner.nextLong();
    }
    return 0;
  }
  
  /* Convert a string to a quadword integer.  */
  //extern long long int strtoll (const char *__restrict __nptr, char **__restrict __endptr, int __base)
  public static long strtoll(char$ptr __nptr, type$ptr<char$ptr> __endptr, int __base) {
    Scanner scanner = new Scanner(Native.$toString(__nptr));
    if (scanner.hasNextLong(__base)) {
      if (__endptr != null) {
        throw new UnsupportedOperationException("Not implemented yet!");
      }
      return scanner.nextLong(__base);
    }
    return 0;
  }
  
  /* Convert a string to an unsigned quadword integer.  */
  //extern unsigned long long int strtoull (const char *__restrict __nptr, char **__restrict __endptr, int __base)
  public static long strtoull(char$ptr __nptr, type$ptr<char$ptr> __endptr, int __base) {
    Scanner scanner = new Scanner(Native.$toString(__nptr));
    if (scanner.hasNextLong(__base)) {
      if (__endptr != null) {
        throw new UnsupportedOperationException("Not implemented yet!");
      }
      return scanner.nextLong(__base);
    }
    return 0;
  }
  
  public static <T> boolean all_of(type$iterator<?, ? extends T> begin, type$iterator<?, ? extends T> end, BoolPredicate<T> p) {
    begin = $tryClone(begin);
    while (begin.$noteq(end)) {
      if (!p.$call(begin.$star())) {
        return false;
      }
      begin.$preInc();
    }
    return true;
  }
  
  /**
   * @brief Return the intersection of two sorted ranges.
   * @ingroup set_algorithms
   * @param __first1 Start of first range.
   * @param __last1 End of first range.
   * @param __first2 Start of second range.
   * @param __last2 End of second range.
   * @return End of the output range.
   * @ingroup set_algorithms
   *
   * This operation iterates over both ranges, copying elements present in both
   * ranges in order to the output range. Iterators increment for each range.
   * When the current element of one range is less than the other, that iterator
   * advances. If an element is contained in both ranges, the element from the
   * first range is copied and both ranges advance. The output range may not
   * overlap either input range.
   */
  public static <_InputIterator1 extends type$iterator, 
                 _InputIterator2 extends type$iterator, 
                 _OutputIterator extends type$iterator>
  _OutputIterator set_intersection(_InputIterator1 __first1, _InputIterator1 __last1,
                  _InputIterator2 __first2, _InputIterator2 __last2,
                  _OutputIterator __result) {
    return set_intersection(__first1, __last1, __first2, __last2, __result, std.DefaultCompare.INSTANCE);
  }
  
  /**
   *  @brief Return the difference of two sorted ranges.
   *  @ingroup set_algorithms
   *  @param  __first1  Start of first range.
   *  @param  __last1   End of first range.
   *  @param  __first2  Start of second range.
   *  @param  __last2   End of second range.
   *  @return  End of the output range.
   *  @ingroup set_algorithms
   *
   *  This operation iterates over both ranges, copying elements present in
   *  the first range but not the second in order to the output range.
   *  Iterators increment for each range.  When the current element of the
   *  first range is less than the second, that element is copied and the
   *  iterator advances.  If the current element of the second range is less,
   *  the iterator advances, but no element is copied.  If an element is
   *  contained in both ranges, no elements are copied and both ranges
   *  advance.  The output range may not overlap either input range.
  */  
  public static <_InputIterator1 extends type$iterator, 
                 _InputIterator2 extends type$iterator, 
                 _OutputIterator extends type$iterator>
  _OutputIterator set_difference(_InputIterator1 __first1, _InputIterator1 __last1,
		   _InputIterator2 __first2, _InputIterator2 __last2,
		   _OutputIterator __result) {
    return set_difference(__first1, __last1, __first2, __last2, __result, std.DefaultCompare.INSTANCE);
  }
  
  public static <_InputIterator1 extends type$iterator, 
                 _InputIterator2 extends type$iterator, 
                 _OutputIterator extends type$iterator>
  _OutputIterator set_difference(_InputIterator1 __first1, _InputIterator1 __last1,
		   _InputIterator2 __first2, _InputIterator2 __last2,
		   _OutputIterator __result, ComparatorLower __comp) {
    __first1 = $tryClone(__first1);
    __first2 = $tryClone(__first2);
    __result = $tryClone(__result);
    while (__first1.$noteq(__last1) && __first2.$noteq(__last2)) {
      if (__comp.$less(__first1.$star(), __first2.$star())) {
         __result.star$ref().$set(__first1.$star());
        __first1.$preInc();
        __result.$preInc();
      } else if (__comp.$less(__first2.$star(), __first1.$star())) {
        __first2.$preInc();
      } else {
        __first1.$preInc();
        __first2.$preInc();
      }
    }
    while (__first1.$noteq(__last1)) {
         __result.star$ref().$set(__first1.$star());
        __first1.$preInc();
        __result.$preInc();
    }
    return __result;
  }

  public static <_Container extends Object, 
                 _InputIterator extends type$iterator, 
                 _OutputIterator extends type$iterator>
  _OutputIterator inserter(_Container __container, _InputIterator __first) {
    return (_OutputIterator)__first;
  }

  public static <T,
                _InputIterator1 extends type$iterator<?,T>, 
                _InputIterator2 extends type$iterator<?,T>, 
                _OutputIterator extends std.setType<T>>
  _OutputIterator set_difference2(_InputIterator1 __first1, _InputIterator1 __last1,
		   _InputIterator2 __first2, _InputIterator2 __last2,
		   _OutputIterator __result) {
    ComparatorLower __comp  = std.DefaultCompare.INSTANCE;
    __first1 = $tryClone(__first1);
    __first2 = $tryClone(__first2);
    while (__first1.$noteq(__last1) && __first2.$noteq(__last2)) {
      if (__comp.$less(__first1.$star(), __first2.$star())) {
         __result.insert(__first1.$star());
        __first1.$preInc();
      } else if (__comp.$less(__first2.$star(), __first1.$star())) {
        __first2.$preInc();
      } else {
        __first1.$preInc();
        __first2.$preInc();
      }
    }
    while (__first1.$noteq(__last1)) {
         __result.insert(__first1.$star());
        __first1.$preInc();
    }
    return __result;
  }

  /**
   * @brief Return the intersection of two sorted ranges using comparison
   * functor.
   * @ingroup set_algorithms
   * @param __first1 Start of first range.
   * @param __last1 End of first range.
   * @param __first2 Start of second range.
   * @param __last2 End of second range.
   * @param __comp The comparison functor.
   * @return End of the output range.
   * @ingroup set_algorithms
   *
   * This operation iterates over both ranges, copying elements present in both
   * ranges in order to the output range. Iterators increment for each range.
   * When the current element of one range is less than the other according to
   * @p __comp, that iterator advances. If an element is contained in both
   * ranges according to @p __comp, the element from the first range is copied
   * and both ranges advance. The output range may not overlap either input
   * range.
   */
  public static <_InputIterator1 extends type$iterator, 
                 _InputIterator2 extends type$iterator, 
                 _OutputIterator extends type$iterator>
  _OutputIterator set_intersection(_InputIterator1 __first1, _InputIterator1 __last1,
                  _InputIterator2 __first2, _InputIterator2 __last2,
                  _OutputIterator __result, ComparatorLower __comp) {
    __first1 = $tryClone(__first1);
    __first2 = $tryClone(__first2);
    __result = $tryClone(__result);
    while (__first1.$noteq(__last1) && __first2.$noteq(__last2)) {
      // JAVA: it seems that in original code conversion to T was used, not dereferencing
      if (__comp.$less(__first1.$star(), __first2.$star())) {
        __first1.$preInc();
      } else if (__comp.$less(__first2.$star(), __first1.$star())) {
        __first2.$preInc();
      } else {
        __result.star$ref().$set(__first1.$star());
        __first1.$preInc();
        __first2.$preInc();
        __result.$preInc();
      }
    }
    return __result;
  }
  
  public static <T> type$iterator<?, T> max_element(type$iterator<?, T> first, type$iterator<?, T> last, TypeType2Bool<T> Predicate) {
    if (first.$eq(last)) {
      return last;
    }
    type$iterator<?, T> largest = $Clone(first);
    first = $Clone(first);
    first.$preInc();
    for (; first.$noteq(last); first.$preInc()) {
      if (Predicate.$call(largest.$star(), first.$star())) {
        largest = $Clone(first);
      }
    }
    return largest;
  }

  public static ulong$ptr max_element(ulong$ptr first, ulong$ptr last) {
    if (first.$eq(last)) {
      return last;
    }
    ulong$ptr largest = $Clone(first);
    first = $Clone(first);
    first.$preInc();
    for (; first.$noteq(last); first.$preInc()) {
      if (Unsigned.$less_ulong(largest.$star(), first.$star())) {
        largest = $Clone(first);
      }
    }
    return largest;
  }  
  
  /////////////////////////////////////////////////
  // atob
  
  private static char$ptr/*char P*/ _getbase(char$ptr/*char P*/ p, int$ptr/*int P*/ basep) {
    if (p.$at(0) == $$0) {
      switch (p.$at(1)) {
       case 'x':
        basep.$set(16);
        break;
       case 't':
       case 'n':
        basep.$set(10);
        break;
       case 'o':
        basep.$set(8);
        break;
       default:
        basep.$set(10);
        return (p);
      }
      return (p.$add(2));
    }
    basep.$set(10);
    return (p);
  }


  // NEW DECLARATION _atob

  /*
  *  _atob(vp,p,base)
  */
  private static int _atob(/*ulong*/ulong$ptr/*P*/ vp, char$ptr/*char P*/ p, int base) {
    /*ulong*/long value;
    ulong$ptr v1 = create_ulong$ptr();
    ulong$ptr v2 = create_ulong$ptr();
    char$ptr/*char P*/ q = create_char$ptr();
    /*char*/byte tmp[/*20*/] = new$char(20);
    int digit;
    if (p.$at(0) == $$0 && (p.$at(1) == $$x || p.$at(1) == $$X)) {
      base = 16;
      p.$inc(2);
    }
    if (base == 16 && $noteq_ptr((q = $tryClone(strchr(p, $$DOT))), null)) {
      if ($greater_uint(q.$sub(p), sizeof(tmp) - 1)) {
        return (0);
      }

      strncpy(create_char$ptr(tmp), p, q.$sub(p));
      tmp[q.$sub(p)] = $$TERM;
      if (!(_atob($AddrOf(v1), create_char$ptr(tmp), 16) != 0)) {
        return (0);
      }

      q.$postInc();
      if (Native.$bool(strchr(q, $$DOT))) {
        return (0);
      }
      if (!(_atob($AddrOf(v2), q, 16) != 0)) {
        return (0);
      }
      vp.$set((v1.$star() << 16) + v2.$star());
      return (1);
    }

    value = vp.$set(0);
    for (; (p.$star() != 0); p.$postInc()) {
      if (p.$star() >= $$0 && p.$star() <= $$9) {
        digit = p.$star() - $$0;
      } else if (p.$star() >= $$a && p.$star() <= $$f) {
        digit = p.$star() - $$a + 10;
      } else if (p.$star() >= $$A && p.$star() <= $$F) {
        digit = p.$star() - $$A + 10;
      } else {
        return (0);
      }
      if (digit >= base) {
        return (0);
      }
      value *= base;
      value += digit;
    }
    vp.$set(value);
    return (1);
  }


  // NEW DECLARATION atob

  /*
  *  atob(vp,p,base) 
  *      converts p to binary result in vp, rtn 1 on success
  */
  private static int atob(int$ptr/*int P*/ vp, char$ptr/*char P*/ p, int base) {
    return atob(vp, p, create_int$ptr(base));
  }
  
  private static int atob(int$ptr/*int P*/ vp, char$ptr/*char P*/ p, int$ptr base) {
    ulong$ptr v = create_ulong$ptr();
    if (base.$star() == 0) {
      p = $tryClone(_getbase(p, $AddrOf(base)));
    }
    if ((_atob($AddrOf(v), p, base.$star()) != 0)) {
      vp.$set($ulong2uint(v.$star()));
      return (1);
    }
    return (0);
  }
  
  /////////////////////////////////////////////////
  // vfscanf, vsscanf, scanf, fscanf, sscanf
  
  // TODO: find real value
  private static final int MAXLN = 1024;

  // NEW DECLARATION vfscanf
  /*
  * ** fscanf --\    sscanf --\
  * **          |                  |
  * **  scanf --+-- vfscanf ----- vsscanf
  * **
  * ** This not been very well tested.. it probably has bugs
  */

  /*
  *  vfscanf(fp,fmt,ap) 
  */
  public static int vfscanf(FILE/*P*/ fp, /*const*/char$ptr/*char P*/ fmt, type$ptr ap) {
    int count;
    /*char*/byte buf[/*1025*/] = new$char(1025);
    if ($eq_ptr(fgets(create_char$ptr(buf), MAXLN, fp), null)) {
      return (-1);
    }
    count = vsscanf(create_char$ptr(buf), fmt, ap);
    return (count);
  }


  // NEW DECLARATION vsscanf

  /*
  *  vsscanf(buf,fmt,ap)
  */
  public static int vsscanf(/*const*/char$ptr/*char P*/ buf, /*const*/char$ptr/*char P*/ s, type$ptr<?> ap) {
    buf = $Clone(buf);
    s = $Clone(s);
    int count;
    int noassign;
    int$ptr width = create_int$ptr();
    int base = 0;
    int lflag;
    /*const*/char$ptr/*char P*/ tc = create_char$ptr();
    char$ptr/*char P*/ t = create_char$ptr();
    /*char*/byte tmp[/*1024*/] = new$char(1024);

    count = noassign = width.$set(lflag = 0);
    while ((s.$star() != 0) && (buf.$star() != 0)) {
      while ((isspace(s.$star()) != 0)) {
        s.$postInc();
      }
      if (s.$star() == $$PERCENT) {
        s.$postInc();
        for (; (s.$star() != 0); s.$postInc()) {
          if (Native.$bool(strchr($("dibouxcsefg%"), s.$star()))) {
            break;
          }
          if (s.$star() == $$STAR) {
            noassign = 1;
          } else if (s.$star() == $$l || s.$star() == $$L) {
            lflag = 1;
          } else if (s.$star() >= $$1 && s.$star() <= $$9) {
            for (tc = $tryClone(s); (isdigit(s.$star()) != 0); s.$postInc())  {
              ;
            }
            strncpy(create_char$ptr(tmp), tc, s.$sub(tc));
            tmp[s.$sub(tc)] = $$TERM;
            atob($AddrOf(width), create_char$ptr(tmp), 10);
            s.$postDec();
          }
        }
        if (s.$star() == $$s) {
          while ((isspace(buf.$star()) != 0)) {
            buf.$postInc();
          }
          if (!(width.$star() != 0)) {
            width.$set(strcspn(buf, $(" \t\n\015\014\013")));
          }
          if (!(noassign != 0)) {
            strncpy(t = $tryClone(__builtin_va_arg(ap, char$ptr/*char P*/ .class)), buf, width.$star());
            t.$set(width.$star(), $$TERM);
          }
          buf.$inc(width.$star());
        } else if (s.$star() == $$c) {
          if (!(width.$star() != 0)) {
            width.$set(1);
          }
          if (!(noassign != 0)) {
            strncpy(t = $tryClone(__builtin_va_arg(ap, char$ptr/*char P*/ .class)), buf, width.$star());
            t.$set(width.$star(), $$TERM);
          }
          buf.$inc(width.$star());
        } else if (Native.$bool(strchr($("dobxu"), s.$star()))) {
          while ((isspace(buf.$star()) != 0)) {
            buf.$postInc();
          }
          if (s.$star() == $$d || s.$star() == $$u) {
            base = 10;
          } else if (s.$star() == $$x) {
            base = 16;
          } else if (s.$star() == $$o) {
            base = 8;
          } else if (s.$star() == $$b) {
            base = 2;
          }
          if (!(width.$star() != 0)) {
            if ((isspace((s.$add(1)).$star()) != 0) || (s.$add(1)).$star() == 0) {
              width.$set(strcspn(buf, $(" \t\n\015\014\013")));
            } else {
              width.$set(strchr(buf, (s.$add(1)).$star()).$sub(buf));
            }
          }
          strncpy(create_char$ptr(tmp), buf, width.$star());
          tmp[width.$star()] = $$TERM;
          buf.$inc(width.$star());
          if (!(noassign != 0)) {
            atob(__builtin_va_arg(ap, int$ptr/*int P*/ .class), create_char$ptr(tmp), base);
          }
        }
        if (!(noassign != 0)) {
          count++;
        }
        width.$set(noassign = lflag = 0);
        s.$postInc();
      } else {
        while ((isspace(buf.$star()) != 0)) {
          buf.$postInc();
        }
        if (s.$star() != buf.$star()) {
          break;
        } else {
          s.$postInc();/*,*/buf.$postInc();
        }
      }
    }
    return (count);
  }


  // NEW DECLARATION scanf

  /*
  *  scanf(fmt,va_alist) 
  */
  public static int scanf(/*const*/char$ptr/*char P*/ fmt, Object ... $VarArg) {
    int count;
    type$ptr ap = create_type$ptr();
    __builtin_va_start($VarArg, ap, fmt);
    count = vfscanf(stdin, fmt, ap);
    __builtin_va_end(ap);
    return (count);
  }


  // NEW DECLARATION fscanf

  /*
  *  fscanf(fp,fmt,va_alist)
  */
  public static int fscanf(FILE/*P*/ fp, /*const*/char$ptr/*char P*/ fmt, Object ... $VarArg) {
    int count;
    type$ptr ap = create_type$ptr();
    __builtin_va_start($VarArg, ap, fmt);
    count = vfscanf(fp, fmt, ap);
    __builtin_va_end(ap);
    return (count);
  }


  // NEW DECLARATION sscanf

  /*
  *  sscanf(buf,fmt,va_alist)
  */
  public static int sscanf(/*const*/char$ptr/*char P*/ buf, /*const*/char$ptr/*char P*/ fmt, Object ... $VarArg) {
    int count;
    type$ptr ap = create_type$ptr();
    __builtin_va_start($VarArg, ap, fmt);
    count = vsscanf(buf, fmt, ap);
    __builtin_va_end(ap);
    return (count);
  }
}
