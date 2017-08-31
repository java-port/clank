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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;
;
import static org.clang.driver.impl.MultilibStatics.*;


/// This corresponds to a single GCC Multilib, or a segment of one controlled
/// by a command line flag
//<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
 FQN="clang::driver::Multilib", NM="_ZN5clang6driver8MultilibE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibE")
//</editor-fold>
public class Multilib implements Destructors.ClassWithDestructor, Native.NativeComparable<Multilib>, NativeCloneable<Multilib> {
/*public:*/
  /*typedef std::vector<std::string> flags_list*/
//  public final class flags_list extends std.vectorString{ };
/*private:*/
  private std.string GCCSuffix;
  private std.string OSSuffix;
  private std.string IncludeSuffix;
  private std.vectorString Flags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::Multilib">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 59,
   FQN="clang::driver::Multilib::Multilib", NM="_ZN5clang6driver8MultilibC1EN4llvm9StringRefES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibC1EN4llvm9StringRefES3_S3_")
  //</editor-fold>
  public Multilib() {
    this(new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), 
      new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public Multilib(StringRef GCCSuffix/*= ""*/) {
    this(GCCSuffix, new StringRef(/*KEEP_STR*/$EMPTY), 
      new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public Multilib(StringRef GCCSuffix/*= ""*/, StringRef OSSuffix/*= ""*/) {
    this(GCCSuffix, OSSuffix, 
      new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public Multilib(StringRef GCCSuffix/*= ""*/, StringRef OSSuffix/*= ""*/, 
      StringRef IncludeSuffix/*= ""*/) {
    /* : GCCSuffix(GCCSuffix.operator basic_string()), OSSuffix(OSSuffix.operator basic_string()), IncludeSuffix(IncludeSuffix.operator basic_string()), Flags()*/ 
    //START JInit
    this.GCCSuffix = GCCSuffix.$string();
    this.OSSuffix = OSSuffix.$string();
    this.IncludeSuffix = IncludeSuffix.$string();
    this.Flags = new std.vectorString(std.string.EMPTY);
    //END JInit
    normalizePathSegment(this.GCCSuffix);
    normalizePathSegment(this.OSSuffix);
    normalizePathSegment(this.IncludeSuffix);
  }

  
  /// \brief Get the detected GCC installation path suffix for the multi-arch
  /// target variant. Always starts with a '/', unless empty
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::gccSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 41,
   FQN="clang::driver::Multilib::gccSuffix", NM="_ZNK5clang6driver8Multilib9gccSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib9gccSuffixEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ gccSuffix() /*const*/ {
    assert (GCCSuffix.empty() || (new StringRef(GCCSuffix).front() == $$SLASH && $greater_uint(GCCSuffix.size(), 1)));
    return GCCSuffix;
  }

  /// Set the GCC installation path suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::gccSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 67,
   FQN="clang::driver::Multilib::gccSuffix", NM="_ZN5clang6driver8Multilib9gccSuffixEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8Multilib9gccSuffixEN4llvm9StringRefE")
  //</editor-fold>
  public Multilib /*&*/ gccSuffix(StringRef S) {
    GCCSuffix.$assignMove(S.$string());
    normalizePathSegment(GCCSuffix);
    return /*Deref*/this;
  }

  
  /// \brief Get the detected os path suffix for the multi-arch
  /// target variant. Always starts with a '/', unless empty
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::osSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 51,
   FQN="clang::driver::Multilib::osSuffix", NM="_ZNK5clang6driver8Multilib8osSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib8osSuffixEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ osSuffix() /*const*/ {
    assert (OSSuffix.empty() || (new StringRef(OSSuffix).front() == $$SLASH && $greater_uint(OSSuffix.size(), 1)));
    return OSSuffix;
  }

  /// Set the os path suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::osSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 73,
   FQN="clang::driver::Multilib::osSuffix", NM="_ZN5clang6driver8Multilib8osSuffixEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8Multilib8osSuffixEN4llvm9StringRefE")
  //</editor-fold>
  public Multilib /*&*/ osSuffix(StringRef S) {
    OSSuffix.$assignMove(S.$string());
    normalizePathSegment(OSSuffix);
    return /*Deref*/this;
  }

  
  /// \brief Get the include directory suffix. Always starts with a '/', unless
  /// empty
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::includeSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 61,
   FQN="clang::driver::Multilib::includeSuffix", NM="_ZNK5clang6driver8Multilib13includeSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib13includeSuffixEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ includeSuffix() /*const*/ {
    assert (IncludeSuffix.empty() || (new StringRef(IncludeSuffix).front() == $$SLASH && $greater_uint(IncludeSuffix.size(), 1)));
    return IncludeSuffix;
  }

  /// Set the include directory suffix
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::includeSuffix">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 79,
   FQN="clang::driver::Multilib::includeSuffix", NM="_ZN5clang6driver8Multilib13includeSuffixEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8Multilib13includeSuffixEN4llvm9StringRefE")
  //</editor-fold>
  public Multilib /*&*/ includeSuffix(StringRef S) {
    IncludeSuffix.$assignMove(S.$string());
    normalizePathSegment(IncludeSuffix);
    return /*Deref*/this;
  }

  
  /// \brief Get the flags that indicate or contraindicate this multilib's use
  /// All elements begin with either '+' or '-'
  ////<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::flags">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 72,
//   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 71,
//   FQN="clang::driver::Multilib::flags", NM="_ZNK5clang6driver8Multilib5flagsEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib5flagsEv")
//  //</editor-fold>
//  public /*const*/std.vectorString/*&*/ flags() /*const*/ {
//    return Flags;
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::flags">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 73,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 72,
   FQN="clang::driver::Multilib::flags", NM="_ZN5clang6driver8Multilib5flagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8Multilib5flagsEv")
  //</editor-fold>
  public std.vectorString/*&*/ flags() {
    return Flags;
  }

  /// Add a flag to the flags list
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::flag">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 75,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 74,
   FQN="clang::driver::Multilib::flag", NM="_ZN5clang6driver8Multilib4flagEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8Multilib4flagEN4llvm9StringRefE")
  //</editor-fold>
  public Multilib /*&*/ flag(StringRef F) {
    assert (F.front() == $$PLUS || F.front() == $$MINUS);
    Flags.push_back(F.$string());
    return /*Deref*/this;
  }

  
  /// \brief print summary of the Multilib
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 85,
   FQN="clang::driver::Multilib::print", NM="_ZNK5clang6driver8Multilib5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    assert (GCCSuffix.empty() || (new StringRef(GCCSuffix).front() == $$SLASH));
    if (GCCSuffix.empty()) {
      OS.$out(/*KEEP_STR*/$DOT);
    } else {
      OS.$out(new StringRef(GCCSuffix).drop_front());
    }
    OS.$out(/*KEEP_STR*/$SEMI);
    for (std.string F : Flags) {
      StringRef Flag = new StringRef(F);
      if (Flag.front() == $$PLUS) {
        OS.$out(/*KEEP_STR*/$AT).$out(Flag.substr(1));
      }
    }
  }

  
  /// Check whether any of the 'against' flags contradict the 'for' flags.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 99,
   FQN="clang::driver::Multilib::isValid", NM="_ZNK5clang6driver8Multilib7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    StringMapInt/*<MallocAllocator>*/ FlagSet = null;
    try {
      FlagSet/*J*/= new StringMapInt/*<MallocAllocator>*/(0);
      for (/*uint*/int I = 0, N = Flags.size(); I != N; ++I) {
        StringRef Flag/*J*/= new StringRef(Flags.$at(I));
        StringMapIteratorInt SI = FlagSet.find(Flag.substr(1));
        assert (new StringRef(Flag).front() == $$PLUS || new StringRef(Flag).front() == $$MINUS);
        if (SI.$eq(FlagSet.end())) {
          FlagSet.$set(Flag.substr(1), I);
        } else if ($noteq_str$C(Flags.$at(I), Flags.$at(SI.$arrow().getValue()))) {
          return false;
        }
      }
      return true;
    } finally {
      if (FlagSet != null) { FlagSet.$destroy(); }
    }
  }

  
  /// Check whether the default is selected
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::isDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 87,
   FQN="clang::driver::Multilib::isDefault", NM="_ZNK5clang6driver8Multilib9isDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8Multilib9isDefaultEv")
  //</editor-fold>
  public boolean isDefault() /*const*/ {
    return GCCSuffix.empty() && OSSuffix.empty() && IncludeSuffix.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 115,
   FQN="clang::driver::Multilib::operator==", NM="_ZNK5clang6driver8MultilibeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZNK5clang6driver8MultilibeqERKS1_")
  //</editor-fold>
  public boolean $eq(/*const*/ Multilib /*&*/ Other) /*const*/ {
    StringSet/*<MallocAllocator>*/ MyFlags = null;
    try {
      // Check whether the flags sets match
      // allowing for the match to be order invariant
      MyFlags/*J*/= new StringSet/*<MallocAllocator>*/();
      for (/*const*/std.string/*&*/ Flag : Flags)  {
        MyFlags.insert(new StringRef(Flag));
      }
      
      for (/*const*/std.string/*&*/ Flag : Other.Flags)  {
        if (MyFlags.find(new StringRef(Flag)).$eq(MyFlags.end())) {
          return false;
        }
      }
      if ($noteq_str$C(osSuffix(), Other.osSuffix())) {
        return false;
      }
      if ($noteq_str$C(gccSuffix(), Other.gccSuffix())) {
        return false;
      }
      if ($noteq_str$C(includeSuffix(), Other.includeSuffix())) {
        return false;
      }
      
      return true;
    } finally {
      if (MyFlags != null) { MyFlags.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::Multilib">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
   FQN="clang::driver::Multilib::Multilib", NM="_ZN5clang6driver8MultilibC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Multilib(/*const*/ Multilib /*&*/ $Prm0) {
    /* : GCCSuffix(.GCCSuffix), OSSuffix(.OSSuffix), IncludeSuffix(.IncludeSuffix), Flags(.Flags)*/ 
    //START JInit
    this.GCCSuffix = new std.string($Prm0.GCCSuffix);
    this.OSSuffix = new std.string($Prm0.OSSuffix);
    this.IncludeSuffix = new std.string($Prm0.IncludeSuffix);
    this.Flags = new std.vectorString($Prm0.Flags);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::Multilib">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
   FQN="clang::driver::Multilib::Multilib", NM="_ZN5clang6driver8MultilibC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibC1EOS1_")
  //</editor-fold>
  public /*inline*/ Multilib(JD$Move _dparam, Multilib /*&&*/$Prm0) {
    /* : GCCSuffix(static_cast<Multilib &&>().GCCSuffix), OSSuffix(static_cast<Multilib &&>().OSSuffix), IncludeSuffix(static_cast<Multilib &&>().IncludeSuffix), Flags(static_cast<Multilib &&>().Flags)*/ 
    //START JInit
    this.GCCSuffix = new std.string(JD$Move.INSTANCE, $Prm0.GCCSuffix);
    this.OSSuffix = new std.string(JD$Move.INSTANCE, $Prm0.OSSuffix);
    this.IncludeSuffix = new std.string(JD$Move.INSTANCE, $Prm0.IncludeSuffix);
    this.Flags = new std.vectorString(JD$Move.INSTANCE, $Prm0.Flags);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
   FQN="clang::driver::Multilib::operator=", NM="_ZN5clang6driver8MultilibaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibaSERKS1_")
  //</editor-fold>
  public /*inline*/ Multilib /*&*/ $assign(/*const*/ Multilib /*&*/ $Prm0) {
    this.GCCSuffix.$assign($Prm0.GCCSuffix);
    this.OSSuffix.$assign($Prm0.OSSuffix);
    this.IncludeSuffix.$assign($Prm0.IncludeSuffix);
    this.Flags.$assign($Prm0.Flags);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
   FQN="clang::driver::Multilib::operator=", NM="_ZN5clang6driver8MultilibaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibaSEOS1_")
  //</editor-fold>
  public /*inline*/ Multilib /*&*/ $assignMove(Multilib /*&&*/$Prm0) {
    this.GCCSuffix.$assignMove($Prm0.GCCSuffix);
    this.OSSuffix.$assignMove($Prm0.OSSuffix);
    this.IncludeSuffix.$assignMove($Prm0.IncludeSuffix);
    this.Flags.$assignMove($Prm0.Flags);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Multilib::~Multilib">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Multilib.h", old_line = 25,
   FQN="clang::driver::Multilib::~Multilib", NM="_ZN5clang6driver8MultilibD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZN5clang6driver8MultilibD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Flags.$destroy();
    IncludeSuffix.$destroy();
    OSSuffix.$destroy();
    GCCSuffix.$destroy();
    //END JDestroy
  }

  @Override public Multilib clone() { return new Multilib(this); }
  
  public String toString() {
    return "" + "GCCSuffix=" + GCCSuffix // NOI18N
              + ", OSSuffix=" + OSSuffix // NOI18N
              + ", IncludeSuffix=" + IncludeSuffix // NOI18N
              + ", Flags=" + Flags; // NOI18N
  }
}
