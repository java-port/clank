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

import static org.clank.support.NativePointer.create_type$ptr;
import org.clank.support.aliases.*;

/**
 *
 * @author petrk
 */
public class std_getopt extends std_atomics {

  /* For communication from `getopt' to the caller.
     When `getopt' finds an option that takes an argument,
     the argument value is returned here.
     Also, when `ordering' is RETURN_IN_ORDER,
     each non-option ARGV-element is returned here.  */

  public static char$ptr optarg;

  /* Index in ARGV of the next element to be scanned.
     This is used for communication to and from the caller
     and for communication between successive calls to `getopt'.

     On entry to `getopt', zero means this is the first call; initialize.

     When `getopt' returns -1, this is the index of the first of the
     non-option elements that the caller should itself scan.

     Otherwise, `optind' communicates from one call to the next
     how much of ARGV has been scanned so far.  */

  public static int optind;

  /* Callers store zero here to inhibit the error message `getopt' prints
     for unrecognized options.  */

  public static int opterr;

  /* Set to an option character which was unrecognized.  */

  public static int optopt;

  /* Describe the long-named options requested by the application.
     The LONG_OPTIONS argument to getopt_long or getopt_long_only is a vector
     of `struct option' terminated by an element containing a name which is
     zero.

     The field `has_arg' is:
     no_argument		(or 0) if the option does not take an argument,
     required_argument	(or 1) if the option requires an argument,
     optional_argument 	(or 2) if the option takes an optional argument.

     If the field `flag' is not NULL, it points to a variable that is set
     to the value given in the field `val' when the option is found, but
     left unchanged if the option is not found.

     To have a long-named option do something other than set an `int' to
     a compiled-in constant, such as set a value from `optarg', set the
     option's `flag' field to zero and its `val' field to a nonzero
     value (the equivalent single-letter option character, if there is
     one).  For long options that have a zero `flag' field, `getopt'
     returns the contents of the `val' field.  */

  public static final class option {
    public char$ptr name;
    /* has_arg can't be an enum because some compilers complain about
       type mismatches in all the code that assumes it is an int.  */
    public int has_arg;
    public int$ptr flag;
    public int val;
    
    public option() {
    }
    
    public option(char$ptr name, int has_arg, Object flag, int val) {
      this.name = name;
      this.has_arg = has_arg;
      this.flag = (int$ptr) flag;
      this.val = val;
    }
  };

  /* Names for the values of the `has_arg' field of `struct option'.  */

  public static final byte no_argument =		0;
  public static final byte required_argument =	1;
  public static final byte optional_argument =	2;


  /* Get definitions and prototypes for functions to process the
     arguments in ARGV (ARGC of them, minus the program name) for
     options given in OPTS.

     Return the option character from OPTS just read.  Return -1 when
     there are no more options.  For unrecognized options, or options
     missing arguments, `optopt' is set to the option letter, and '?' is
     returned.

     The OPTS string is a list of characters which are recognized option
     letters, optionally followed by colons, specifying that that letter
     takes an argument, to be placed in `optarg'.

     If a letter in OPTS is followed by two colons, its argument is
     optional.  This behavior is specific to the GNU `getopt'.

     The argument `--' causes premature termination of argument
     scanning, explicitly telling `getopt' that there are no more
     options.

     If OPTS begins with `--', then non-option arguments are treated as
     arguments to the option '\0'.  This behavior is specific to the GNU
     `getopt'.  */

  /* Many other libraries have conflicting prototypes for getopt, with
     differences in the consts, in stdlib.h.  To avoid compilation
     errors, only prototype getopt for the GNU C library.  */
  public static int getopt(int ___argc, type$ptr<char$ptr> ___argv, char$ptr __shortopts) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public static int getopt_long (int ___argc, type$ptr<char$ptr> ___argv,
        char$ptr __shortopts,
              type$ptr<option>/*P*/ __longopts, int$ptr __longind) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static int getopt_long (int ___argc, type$ptr<char$ptr> ___argv,
        char$ptr __shortopts,
              option[]/*P*/ __longopts, int$ptr __longind) {
    return getopt_long(___argc, ___argv, __shortopts, create_type$ptr(__longopts), __longind);
  }
  public static int getopt_long_only (int ___argc, type$ptr<char$ptr> ___argv,
             char$ptr __shortopts,
                   type$ptr<option>/*P*/ __longopts, int$ptr __longind) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static int getopt_long_only (int ___argc, type$ptr<char$ptr> ___argv,
             char$ptr __shortopts,
                   option[]/*P*/ __longopts, int$ptr __longind) {
    return getopt_long_only(___argc, ___argv, __shortopts, create_type$ptr(__longopts), __longind);
  }
}
