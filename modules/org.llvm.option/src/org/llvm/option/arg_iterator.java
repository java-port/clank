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

package org.llvm.option;


import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.option.*;


/// arg_iterator - Iterates through arguments stored inside an ArgList.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 31,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 29,
 FQN = "llvm::opt::arg_iterator", NM = "_ZN4llvm3opt12arg_iteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorE")
//</editor-fold>
public class arg_iterator implements type$iterator<arg_iterator, Arg> {
  /// The current argument.
  type$ptr<Arg /*P*/ > Current;
  
  /// The argument list we are iterating over.
  private /*const*/ArgList /*&*/ Args;
  
  /// Optional filters on the arguments which will be match. Most clients
  /// should never want to iterate over arguments without filters, so we won't
  /// bother to factor this into two separate iterator implementations.
  //
  // FIXME: Make efficient; the idea is to provide efficient iteration over
  // all arguments which match a particular id and then just provide an
  // iterator combinator which takes multiple iterators which can be
  // efficiently compared and returns them in order.
  private OptSpecifier Id0;
  private OptSpecifier Id1;
  private OptSpecifier Id2;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::SkipToNextArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 22,
   FQN="llvm::opt::arg_iterator::SkipToNextArg", NM="_ZN4llvm3opt12arg_iterator13SkipToNextArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iterator13SkipToNextArgEv")
  //</editor-fold>
  private void SkipToNextArg() {
    for (; Current.$noteq(Args.end()); Current.$preInc()) {
      // Done if there are no filters.
      if (!Id0.isValid()) {
        break;
      }

      // Otherwise require a match.
      /*const*/ Option /*&*/ O = (Current.$star()).getOption();
      if (O.matches(/*NO_COPY*/Id0)
         || (Id1.isValid() && O.matches(/*NO_COPY*/Id1))
         || (Id2.isValid() && O.matches(/*NO_COPY*/Id2))) {
        break;
      }
    }
  }

/*public:*/
  /*typedef Arg *const *value_type*/
//  public final class value_type extends type$ptr<Arg> { };
  /*typedef Arg *const &reference*/
//  public final class reference extends Arg /*P*/ /*const*/ /*&*/ { };
  /*typedef Arg *const *pointer*/
//  public final class pointer extends type$ptr<Arg> { };
  /*typedef std::forward_iterator_tag iterator_category*/
//  public final class iterator_category extends std.forward_iterator_tag{ };
  /*typedef std::ptrdiff_t difference_type*/;
  
//<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::arg_iterator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 57,
          old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 55,
          FQN = "llvm::opt::arg_iterator::arg_iterator", NM = "_ZN4llvm3opt12arg_iteratorC1EPKPNS0_3ArgERKNS0_7ArgListENS0_12OptSpecifierES9_S9_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorC1EPKPNS0_3ArgERKNS0_7ArgListENS0_12OptSpecifierES9_S9_")
//</editor-fold>
  public arg_iterator(type$ptr<Arg /*P*/> it, /*const*/ ArgList /*&*/ Args) {
    this(it, Args,
            new OptSpecifier(0/*U*/), new OptSpecifier(0/*U*/),
            new OptSpecifier(0/*U*/));
  }

  public arg_iterator(type$ptr<Arg /*P*/> it, /*const*/ ArgList /*&*/ Args,
          OptSpecifier Id0/*= 0UU*/) {
    this(it, Args,
            Id0, new OptSpecifier(0/*U*/),
            new OptSpecifier(0/*U*/));
  }

  public arg_iterator(type$ptr<Arg /*P*/> it, /*const*/ ArgList /*&*/ Args,
          OptSpecifier Id0/*= 0UU*/, OptSpecifier Id1/*= 0UU*/) {
    this(it, Args,
            Id0, Id1,
            new OptSpecifier(0/*U*/));
  }

  public arg_iterator(type$ptr<Arg /*P*/> it, /*const*/ ArgList /*&*/ Args,
          OptSpecifier Id0/*= 0UU*/, OptSpecifier Id1/*= 0UU*/,
          OptSpecifier Id2/*= 0UU*/) {
    /* : Current(it), Args(Args), Id0(Id0), Id1(Id1), Id2(Id2)*/
    //START JInit
    this.Current = $tryClone(it);
    this./*&*/Args =/*&*/ Args;
    this.Id0 = new OptSpecifier(Id0);
    this.Id1 = new OptSpecifier(Id1);
    this.Id2 = new OptSpecifier(Id2);
    //END JInit
    SkipToNextArg();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::operator const Arg * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 64,
   FQN="llvm::opt::arg_iterator::operator const Arg * ", NM="_ZN4llvm3opt12arg_iteratorcvPKNS0_3ArgEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorcvPKNS0_3ArgEEv")
  //</editor-fold>
  public /*const*/Arg /*P*/ $ArgPtr /*P*/ () {
    return Current.$star();
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 63,
   FQN = "llvm::opt::arg_iterator::operator*", NM = "_ZNK4llvm3opt12arg_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12arg_iteratordeEv")
  //</editor-fold>
  public Arg /*P*/ /*const*/ /*&*/ $star() /*const*/ {
    return Current.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 64,
   FQN = "llvm::opt::arg_iterator::operator->", NM = "_ZNK4llvm3opt12arg_iteratorptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt12arg_iteratorptEv")
  //</editor-fold>
  public Arg $arrow() /*const*/ {
    return Current.$arrow();
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 66,
   FQN = "llvm::opt::arg_iterator::operator++", NM = "_ZN4llvm3opt12arg_iteratorppEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorppEv")
  //</editor-fold>
  public arg_iterator /*&*/ $preInc() {
    Current.$preInc();
    SkipToNextArg();
    return /*Deref*/this;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 72,
   FQN = "llvm::opt::arg_iterator::operator++", NM = "_ZN4llvm3opt12arg_iteratorppEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorppEi")
  //</editor-fold>
  public arg_iterator $postInc() {
    arg_iterator tmp/*J*/= new arg_iterator(/*Deref*/this);
    (/*Deref*/this).$preInc();
    return tmp;
  }

  
  /*friend bool operator==(arg_iterator LHS, arg_iterator RHS) */;
  /*friend bool operator!=(arg_iterator LHS, arg_iterator RHS) */;
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::arg_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 31,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 29,
   FQN = "llvm::opt::arg_iterator::arg_iterator", NM = "_ZN4llvm3opt12arg_iteratorC1ERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ arg_iterator(/*const*/arg_iterator /*&*/ $Prm0)/* throw()*/ {
    /* : Current(.Current), Args(.Args), Id0(.Id0), Id1(.Id1), Id2(.Id2)*/ 
    //START JInit
    this.Current = $tryClone($Prm0.Current);
    this.Args = $Prm0.Args;
    this.Id0 = new OptSpecifier($Prm0.Id0);
    this.Id1 = new OptSpecifier($Prm0.Id1);
    this.Id2 = new OptSpecifier($Prm0.Id2);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::arg_iterator::arg_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 31,
   FQN="llvm::opt::arg_iterator::arg_iterator", NM="_ZN4llvm3opt12arg_iteratorC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt12arg_iteratorC1EOS1_")
  //</editor-fold>
  public /*inline*/ arg_iterator(JD$Move _dparam, arg_iterator /*&&*/$Prm0) {
    /* : Current(static_cast<arg_iterator &&>().Current), Args(static_cast<arg_iterator &&>().Args), Id0(static_cast<arg_iterator &&>().Id0), Id1(static_cast<arg_iterator &&>().Id1), Id2(static_cast<arg_iterator &&>().Id2)*/ 
    //START JInit
    this.Current = $tryClone($Prm0.Current);
    this./*&*/Args=/*&*/$Prm0.Args;
    this.Id0 = new OptSpecifier(JD$Move.INSTANCE, $Prm0.Id0);
    this.Id1 = new OptSpecifier(JD$Move.INSTANCE, $Prm0.Id1);
    this.Id2 = new OptSpecifier(JD$Move.INSTANCE, $Prm0.Id2);
    //END JInit
  }  
  
  @Override
  public type$ref<Arg> star$ref() {
//    return Current.star$ref();
    throw new UnsupportedOperationException();
  }

  @Override
  public int $sub(arg_iterator iter) {
//    return Current.$sub(iter.Current);
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $preDec() {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $postDec() {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $inc(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $dec(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $add(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator $sub(int amount) {
    throw new UnsupportedOperationException();
  }

  @Override
  public arg_iterator clone() {
    return new arg_iterator(this);
  }

  @Override
  public arg_iterator const_clone() {
    return new arg_iterator(this);
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof arg_iterator) {
      final arg_iterator arg_other = (arg_iterator) other;
      return this.Current.$noteq(arg_other.Current);
    }
    throw new IllegalArgumentException("other must be an arg_iterator");
  }

  @Override
  public boolean $eq(Object other) {
    return !$noteq(other);
  }
  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::opt::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 78,
   FQN = "llvm::opt::operator==", NM = "_ZN4llvm3opteqENS0_12arg_iteratorES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opteqENS0_12arg_iteratorES1_")
  //</editor-fold>
  public static boolean $eq_arg_iterator(arg_iterator LHS, arg_iterator RHS) {
    return LHS.Current.$eq(RHS.Current);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::opt::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 81,
   FQN = "llvm::opt::operator!=", NM = "_ZN4llvm3optneENS0_12arg_iteratorES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3optneENS0_12arg_iteratorES1_")
  //</editor-fold>
  public static boolean $noteq_arg_iterator(arg_iterator LHS, arg_iterator RHS) {
    return !($eq_arg_iterator(new arg_iterator(LHS), new arg_iterator(RHS)));
  }
  
  public String toString() {
    return "" + "Current=" + Current // NOI18N
              + ", Args=" + Args // NOI18N
              + ", Id0=" + Id0 // NOI18N
              + ", Id1=" + Id1 // NOI18N
              + ", Id2=" + Id2; // NOI18N
  }  
}
