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

package org.clang.driver;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;
import static org.clang.driver.DriverGlobals.*;
import org.clang.driver.java.DriverFunctionPointers.*;
;
import static org.clang.driver.impl.MultilibStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Iterable*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 96,
 FQN="clang::driver::MultilibSet", NM="_ZN5clang6driver11MultilibSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSetE")
//</editor-fold>
public class MultilibSet implements Destructors.ClassWithDestructor, Iterable<Multilib> {
/*public:*/
  /*typedef std::vector<Multilib> multilib_list*/
//  public final class multilib_list extends std.vector<Multilib>{ };
  /*typedef multilib_list::iterator iterator*/
//  public final class iterator extends std.vector.iterator<Multilib>{ };
  /*typedef multilib_list::const_iterator const_iterator*/
//  public final class const_iterator extends std.vector.iterator<Multilib>{ };
  
  /*typedef std::function<std::vector<std::string> (const Multilib &)> IncludeDirsFunc*/
//  public final class IncludeDirsFunc extends std.function<IncludeDirsFunc>{ };
  
  /*typedef llvm::function_ref<bool (const Multilib &)> FilterCallback*/
//  public final class FilterCallback extends FilterCallback{ };
/*private:*/
  private std.vector<Multilib> Multilibs;
  private IncludeDirsFunc IncludeCallback;
  private IncludeDirsFunc FilePathsCallback;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::MultilibSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 113,
   FQN="clang::driver::MultilibSet::MultilibSet", NM="_ZN5clang6driver11MultilibSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSetC1Ev")
  //</editor-fold>
  public MultilibSet() {
    /* : Multilibs(), IncludeCallback(), FilePathsCallback()*/ 
    //START JInit
    this.Multilibs = new std.vector<Multilib>(new Multilib());
    this.IncludeCallback = null;
    this.FilePathsCallback = null;
    //END JInit
  }

  
  /// Add an optional Multilib segment
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Maybe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 143,
   FQN="clang::driver::MultilibSet::Maybe", NM="_ZN5clang6driver11MultilibSet5MaybeERKNS0_8MultilibE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet5MaybeERKNS0_8MultilibE")
  //</editor-fold>
  public MultilibSet /*&*/ Maybe(/*const*/ Multilib /*&*/ M) {
    Multilib Opposite = null;
    try {
      Opposite/*J*/= new Multilib();
      // Negate any '+' flags
      for (std.string F : M.flags()) {
        StringRef Flag = new StringRef(F);
        if (Flag.front() == $$PLUS) {
          Opposite.flags().push_back(($add_char$ptr$C_StringRef(/*KEEP_STR*/$MINUS, Flag.substr(1))).str());
        }
      }
      return Either(M, Opposite);
    } finally {
      if (Opposite != null) { Opposite.$destroy(); }
    }
  }

  
  /// Add a set of mutually incompatible Multilib segments
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Either">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 153,
   FQN="clang::driver::MultilibSet::Either", NM="_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_")
  //</editor-fold>
  public MultilibSet /*&*/ Either(/*const*/ Multilib /*&*/ M1, /*const*/ Multilib /*&*/ M2) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*2*/] {M1, M2}))/* }*/));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Either">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 157,
   FQN="clang::driver::MultilibSet::Either", NM="_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_")
  //</editor-fold>
  public MultilibSet /*&*/ Either(/*const*/ Multilib /*&*/ M1, /*const*/ Multilib /*&*/ M2, 
        /*const*/ Multilib /*&*/ M3) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*3*/] {M1, M2, M3}))/* }*/));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Either">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 162,
   FQN="clang::driver::MultilibSet::Either", NM="_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_S4_")
  //</editor-fold>
  public MultilibSet /*&*/ Either(/*const*/ Multilib /*&*/ M1, /*const*/ Multilib /*&*/ M2, 
        /*const*/ Multilib /*&*/ M3, /*const*/ Multilib /*&*/ M4) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*4*/] {M1, M2, M3, M4}))/* }*/));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Either">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 167,
   FQN="clang::driver::MultilibSet::Either", NM="_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet6EitherERKNS0_8MultilibES4_S4_S4_S4_")
  //</editor-fold>
  public MultilibSet /*&*/ Either(/*const*/ Multilib /*&*/ M1, /*const*/ Multilib /*&*/ M2, 
        /*const*/ Multilib /*&*/ M3, /*const*/ Multilib /*&*/ M4, 
        /*const*/ Multilib /*&*/ M5) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*5*/] {M1, M2, M3, M4, M5}))/* }*/));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::Either">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 192,
   FQN="clang::driver::MultilibSet::Either", NM="_ZN5clang6driver11MultilibSet6EitherEN4llvm8ArrayRefINS0_8MultilibEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet6EitherEN4llvm8ArrayRefINS0_8MultilibEEE")
  //</editor-fold>
  public MultilibSet /*&*/ Either(ArrayRef<Multilib> MultilibSegments) {
    std.vector<Multilib> Composed = null;
    try {
      Composed/*J*/= new std.vector<Multilib>(new Multilib());
      if (Multilibs.empty()) {
        Multilibs.insert(new std.vector.iterator<Multilib>(Multilibs.end()), MultilibSegments.begin(), 
            MultilibSegments.end());
      } else {
        for (/*const*/ Multilib /*&*/ New : MultilibSegments) {
          for (/*const*/ Multilib /*&*/ Base : /*Deref*/this) {
            Multilib MO = null;
            try {
              MO = compose(Base, New);
              if (MO.isValid()) {
                Composed.push_back(MO);
              }
            } finally {
              if (MO != null) { MO.$destroy(); }
            }
          }
        }
        
        Multilibs.$assign(Composed);
      }
      
      return /*Deref*/this;
    } finally {
      if (Composed != null) { Composed.$destroy(); }
    }
  }

  
  /// Filter out some subset of the Multilibs using a user defined callback
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::FilterOut">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 213,
   FQN="clang::driver::MultilibSet::FilterOut", NM="_ZN5clang6driver11MultilibSet9FilterOutEN4llvm12function_refIFbRKNS0_8MultilibEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet9FilterOutEN4llvm12function_refIFbRKNS0_8MultilibEEEE")
  //</editor-fold>
  public MultilibSet /*&*/ FilterOut(FilterCallback F) {
    filterInPlace(/*NO_COPY*/F, Multilibs);
    return /*Deref*/this;
  }

  /// Filter out those Multilibs whose gccSuffix matches the given expression
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::FilterOut">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 218,
   FQN="clang::driver::MultilibSet::FilterOut", NM="_ZN5clang6driver11MultilibSet9FilterOutEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet9FilterOutEPKc")
  //</editor-fold>
  public final MultilibSet /*&*/ FilterOut(/*const*/String/*char P*/ Regex) {
    return FilterOut($(Regex));
  }
  public MultilibSet /*&*/ FilterOut(/*const*/char$ptr/*char P*/ Regex) {
    final Regex R = new Regex(new StringRef(Regex));
    try {
      std.string Error/*J*/= new std.string();
      if (!R.isValid(Error)) {
        llvm.errs().$out(Error);
        throw new llvm_unreachable("Invalid regex!");
      }
      
      filterInPlace(new FilterCallback(JD$NotSame2Callable.INSTANCE,  (M) -> 
                {
                  return R.match(new StringRef(M.gccSuffix()));
                }
), 
          Multilibs);
      return /*Deref*/this;
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }

  
  /// Add a completed Multilib to the set
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 233,
   FQN="clang::driver::MultilibSet::push_back", NM="_ZN5clang6driver11MultilibSet9push_backERKNS0_8MultilibE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet9push_backERKNS0_8MultilibE")
  //</editor-fold>
  public void push_back(/*const*/ Multilib /*&*/ M) {
    Multilibs.push_back(M);
  }

  
  /// Union this set of multilibs with another
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::combineWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 235,
   FQN="clang::driver::MultilibSet::combineWith", NM="_ZN5clang6driver11MultilibSet11combineWithERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet11combineWithERKS1_")
  //</editor-fold>
  public void combineWith(/*const*/ MultilibSet /*&*/ Other) {
    Multilibs.insert(new std.vector.iterator<Multilib>(Multilibs.end()), Other.begin(), Other.end());
  }

  
  /// Remove all of thie multilibs from the set
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 141,
   FQN="clang::driver::MultilibSet::clear", NM="_ZN5clang6driver11MultilibSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet5clearEv")
  //</editor-fold>
  public void clear() {
    Multilibs.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 143,
   FQN="clang::driver::MultilibSet::begin", NM="_ZN5clang6driver11MultilibSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet5beginEv")
  //</editor-fold>
  public std.vector.iterator<Multilib> begin() {
    return Multilibs.begin();
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::begin">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 144,
//   FQN="clang::driver::MultilibSet::begin", NM="_ZNK5clang6driver11MultilibSet5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet5beginEv")
//  //</editor-fold>
//  public std.vector.iterator<Multilib> begin() /*const*/ {
//    return Multilibs.begin();
//  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 146,
   FQN="clang::driver::MultilibSet::end", NM="_ZN5clang6driver11MultilibSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet3endEv")
  //</editor-fold>
  public std.vector.iterator<Multilib> end() {
    return Multilibs.end();
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::end">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 147,
//   FQN="clang::driver::MultilibSet::end", NM="_ZNK5clang6driver11MultilibSet3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet3endEv")
//  //</editor-fold>
//  public std.vector.iterator<Multilib> end() /*const*/ {
//    return Multilibs.end();
//  }

  
  /// Pick the best multilib in the set, \returns false if none are compatible
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::select">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 245,
   FQN="clang::driver::MultilibSet::select", NM="_ZNK5clang6driver11MultilibSet6selectERKSt6vectorISsSaISsEERNS0_8MultilibE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet6selectERKSt6vectorISsSaISsEERNS0_8MultilibE")
  //</editor-fold>
  public boolean select(/*const*/std.vectorString/*&*/ Flags, Multilib /*&*/ M) /*const*/ {
    final StringMapBool FlagSet/*J*/= new StringMapBool(false);
    std.vector<Multilib> Filtered = null;
    try {
      // Stuff all of the flags into the FlagSet such that a true mappend indicates
      // the flag was enabled, and a false mappend indicates the flag was disabled.
      for (std.string F : Flags)  {
        StringRef Flag = new StringRef(F);
        FlagSet.$set(Flag.substr(1), isFlagEnabled(new StringRef(Flag)));
      }
      
      Filtered = filterCopy(new FilterCallback(JD$NotSame2Callable.INSTANCE,  (_M) -> 
                {
                  for (std.string F : _M.flags()) {
                    StringRef Flag = new StringRef(F);
                    StringMapIteratorBool SI = new StringMapIteratorBool(JD$Move.INSTANCE, FlagSet.find(Flag.substr(1)));
                    if (SI.$noteq(FlagSet.end())) {
                      if (SI.$arrow().getValue() != isFlagEnabled(new StringRef(Flag))) {
                        return true;
                      }
                    }
                  }
                  return false;
                }
), Multilibs);
      if (Filtered.size() == 0) {
        return false;
      }
      if (Filtered.size() == 1) {
        M.$assign(Filtered.$at(0));
        return true;
      }
      
      // TODO: pick the "best" multlib when more than one is suitable
      assert (false);
      return false;
    } finally {
      if (Filtered != null) { Filtered.$destroy(); }
      if (FlagSet != null) { FlagSet.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 152,
   FQN="clang::driver::MultilibSet::size", NM="_ZNK5clang6driver11MultilibSet4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Multilibs.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 275,
   FQN="clang::driver::MultilibSet::print", NM="_ZNK5clang6driver11MultilibSet5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    for (/*const*/ Multilib /*&*/ M : /*Deref*/this)  {
      $out_raw_ostream_Multilib$C(OS, M).$out(/*KEEP_STR*/$LF);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::setIncludeDirsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 156,
   FQN="clang::driver::MultilibSet::setIncludeDirsCallback", NM="_ZN5clang6driver11MultilibSet22setIncludeDirsCallbackESt8functionIFSt6vectorISsSaISsEERKNS0_8MultilibEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet22setIncludeDirsCallbackESt8functionIFSt6vectorISsSaISsEERKNS0_8MultilibEEE")
  //</editor-fold>
  public MultilibSet /*&*/ setIncludeDirsCallback(IncludeDirsFunc F) {
    IncludeCallback = F;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::includeDirsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 160,
   FQN="clang::driver::MultilibSet::includeDirsCallback", NM="_ZNK5clang6driver11MultilibSet19includeDirsCallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet19includeDirsCallbackEv")
  //</editor-fold>
  public /*const*/IncludeDirsFunc/*&*/ includeDirsCallback() /*const*/ {
    return IncludeCallback;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::setFilePathsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 162,
   FQN="clang::driver::MultilibSet::setFilePathsCallback", NM="_ZN5clang6driver11MultilibSet20setFilePathsCallbackESt8functionIFSt6vectorISsSaISsEERKNS0_8MultilibEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet20setFilePathsCallbackESt8functionIFSt6vectorISsSaISsEERKNS0_8MultilibEEE")
  //</editor-fold>
  public MultilibSet /*&*/ setFilePathsCallback(IncludeDirsFunc F) {
    FilePathsCallback = F;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::filePathsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 166,
   FQN="clang::driver::MultilibSet::filePathsCallback", NM="_ZNK5clang6driver11MultilibSet17filePathsCallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver11MultilibSet17filePathsCallbackEv")
  //</editor-fold>
  public /*const*/IncludeDirsFunc/*&*/ filePathsCallback() /*const*/ {
    return FilePathsCallback;
  }

/*private:*/
  /// Apply the filter to Multilibs and return the subset that remains
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::filterCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 280,
   FQN="clang::driver::MultilibSet::filterCopy", NM="_ZN5clang6driver11MultilibSet10filterCopyEN4llvm12function_refIFbRKNS0_8MultilibEEEERKSt6vectorIS4_SaIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet10filterCopyEN4llvm12function_refIFbRKNS0_8MultilibEEEERKSt6vectorIS4_SaIS4_EE")
  //</editor-fold>
  private static std.vector<Multilib> filterCopy(FilterCallback F, 
            /*const*/std.vector<Multilib>/*&*/ Ms) {
    std.vector<Multilib> Copy = null;
    try {
      Copy/*J*/= new std.vector<Multilib>(Ms);
      filterInPlace(/*NO_COPY*/F, Copy);
      return new std.vector<Multilib>(JD$Move.INSTANCE, Copy);
    } finally {
      if (Copy != null) { Copy.$destroy(); }
    }
  }

  
  /// Apply the filter to the multilib_list, removing those that don't match
  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::filterInPlace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 287,
   FQN="clang::driver::MultilibSet::filterInPlace", NM="_ZN5clang6driver11MultilibSet13filterInPlaceEN4llvm12function_refIFbRKNS0_8MultilibEEEERSt6vectorIS4_SaIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver11MultilibSet13filterInPlaceEN4llvm12function_refIFbRKNS0_8MultilibEEEERSt6vectorIS4_SaIS4_EE")
  //</editor-fold>
  private static void filterInPlace(FilterCallback F, std.vector<Multilib>/*&*/ Ms) {
    Ms.erase(new std.vector.iterator<Multilib>(std.remove_if(Ms.begin(), Ms.end(), (F))), new std.vector.iterator<Multilib>(Ms.end()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::~MultilibSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 96,
   FQN="clang::driver::MultilibSet::~MultilibSet", NM="_ZN5clang6driver11MultilibSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver11MultilibSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FilePathsCallback = null;
    IncludeCallback = null;
    Multilibs.$destroy();
    //END JDestroy
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::MultilibSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 96,
   FQN="clang::driver::MultilibSet::MultilibSet", NM="_ZN5clang6driver11MultilibSetC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver11MultilibSetC1ERKS1_")
  //</editor-fold>
  public /*inline*/ MultilibSet(/*const*/ MultilibSet /*&*/ $Prm0) {
    /* : Multilibs(.Multilibs), IncludeCallback(.IncludeCallback), FilePathsCallback(.FilePathsCallback)*/ 
    //START JInit
    this.Multilibs = new std.vector<Multilib>($Prm0.Multilibs);
    this.IncludeCallback = $Prm0.IncludeCallback;
    this.FilePathsCallback = $Prm0.FilePathsCallback;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::MultilibSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 96,
   FQN="clang::driver::MultilibSet::operator=", NM="_ZN5clang6driver11MultilibSetaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver11MultilibSetaSERKS1_")
  //</editor-fold>
  public /*inline*/ MultilibSet /*&*/ $assign(/*const*/ MultilibSet /*&*/ $Prm0) {
    this.Multilibs.$assign($Prm0.Multilibs);
    this.IncludeCallback = $Prm0.IncludeCallback;
    this.FilePathsCallback = $Prm0.FilePathsCallback;
    return /*Deref*/this;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public Iterator<Multilib> iterator() {
    return new JavaIterator(begin(), end());
  }
  
//  private static final class JavaIterator implements Iterator<Multilib> {
//    private final std.vector.iterator<Multilib> iter;
//    private final std.vector.iterator<Multilib> end;
//
//    public JavaIterator(StdVector.iterator<Multilib> iter, StdVector.iterator<Multilib> end) {
//      this.iter = iter;
//      this.end = end;
//    }
//
//    @Override
//    public boolean hasNext() {
//      return iter.$noteq(end);
//    }
//
//    @Override
//    public Multilib next() {
//      Multilib val = iter.$star();
//      iter.$preInc();
//      return val;
//    }
//
//    @Override
//    public void remove() {
//      throw new UnsupportedOperationException("Not supported.");
//    }
//  }
  
  public String toString() {
    return "" + "Multilibs=" + Multilibs // NOI18N
              + ", IncludeCallback=" + IncludeCallback // NOI18N
              + ", FilePathsCallback=" + FilePathsCallback; // NOI18N
  }
}
