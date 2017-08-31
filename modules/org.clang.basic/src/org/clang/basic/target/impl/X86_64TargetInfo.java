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

package org.clang.basic.target.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;


// x86-64 generic target
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4312,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3970,
 FQN="(anonymous namespace)::X86_64TargetInfo", NM="_ZN12_GLOBAL__N_116X86_64TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_64TargetInfoE")
//</editor-fold>
public class X86_64TargetInfo extends /*public*/ X86TargetInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::X86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4314,
   FQN="(anonymous namespace)::X86_64TargetInfo::X86_64TargetInfo", NM="_ZN12_GLOBAL__N_116X86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public X86_64TargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : X86TargetInfo(Triple, Opts)*/ 
    //START JInit
    super(_Triple, Opts);
    //END JInit
    /*const*/boolean IsX32 = getTriple().getEnvironment() == Triple.EnvironmentType.GNUX32;
    boolean IsWinCOFF = getTriple().isOSWindows() && getTriple().isOSBinFormatCOFF();
    LongWidth = LongAlign = PointerWidth = PointerAlign = $int2uchar(IsX32 ? 32 : 64);
    LongDoubleWidth = $int2uchar(128);
    LongDoubleAlign = $int2uchar(128);
    LargeArrayMinWidth = $int2uchar(128);
    LargeArrayAlign = $int2uchar(128);
    SuitableAlign = $int2uchar(128);
    SizeType = IsX32 ? IntType.UnsignedInt : IntType.UnsignedLong;
    PtrDiffType = IsX32 ? IntType.SignedInt : IntType.SignedLong;
    IntPtrType = IsX32 ? IntType.SignedInt : IntType.SignedLong;
    IntMaxType = IsX32 ? IntType.SignedLongLong : IntType.SignedLong;
    Int64Type = IsX32 ? IntType.SignedLongLong : IntType.SignedLong;
    RegParmMax = 6;
    
    // Pointers are 32-bit in x32.
    resetDataLayout(new StringRef(IsX32 ? $("e-m:e-p:32:32-i64:64-f80:128-n8:16:32:64-S128") : IsWinCOFF ? $("e-m:w-i64:64-f80:128-n8:16:32:64-S128") : $("e-m:e-i64:64-f80:128-n8:16:32:64-S128")));
    
    // Use fpret only for long double.
    RealTypeUsesObjCFPRet = (byte) (1 << TargetInfo.RealType.LongDouble.getValue());
    
    // Use fp2ret for _Complex long double.
    ComplexLongDoubleUsesFP2Ret = true;
    
    // Make __builtin_ms_va_list available.
    HasBuiltinMSVaList = true;
    
    // x86-64 has atomics up to 16 bytes.
    MaxAtomicPromoteWidth = $int2uchar(128);
    MaxAtomicInlineWidth = $int2uchar(128);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4008,
   FQN="(anonymous namespace)::X86_64TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.X86_64ABIBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4355,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4012,
   FQN="(anonymous namespace)::X86_64TargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 0;
    }
    if (RegNo == 1) {
      return 1;
    }
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4018,
   FQN="(anonymous namespace)::X86_64TargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_C:
     case CC_Swift:
     case CC_X86VectorCall:
     case CC_IntelOclBicc:
     case CC_X86_64Win64:
     case CC_PreserveMost:
     case CC_PreserveAll:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::getDefaultCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4376,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4025,
   FQN="(anonymous namespace)::X86_64TargetInfo::getDefaultCallingConv", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE")
  //</editor-fold>
  @Override public CallingConv getDefaultCallingConv(CallingConvMethodType MT) /*const*//* override*/ {
    return CallingConv.CC_C;
  }

  
  // for x32 we need it here explicitly
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::hasInt128Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4381,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4030,
   FQN="(anonymous namespace)::X86_64TargetInfo::hasInt128Type", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo13hasInt128TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo13hasInt128TypeEv")
  //</editor-fold>
  @Override public boolean hasInt128Type() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::getUnwindWordWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4382,
   FQN="(anonymous namespace)::X86_64TargetInfo::getUnwindWordWidth", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo18getUnwindWordWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo18getUnwindWordWidthEv")
  //</editor-fold>
  @Override public /*uint*/int getUnwindWordWidth() /*const*//* override*/ {
    return 64;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::getRegisterWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4383,
   FQN="(anonymous namespace)::X86_64TargetInfo::getRegisterWidth", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo16getRegisterWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo16getRegisterWidthEv")
  //</editor-fold>
  @Override public /*uint*/int getRegisterWidth() /*const*//* override*/ {
    return 64;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::validateGlobalRegisterVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4385,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4032,
   FQN="(anonymous namespace)::X86_64TargetInfo::validateGlobalRegisterVariable", NM="_ZNK12_GLOBAL__N_116X86_64TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_64TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb")
  //</editor-fold>
  @Override public boolean validateGlobalRegisterVariable(StringRef RegName, 
                                /*uint*/int RegSize, 
                                bool$ref/*bool &*/ HasSizeMismatch) /*const*//* override*/ {
    // rsp and rbp are the only 64-bit registers the x86 backend can currently
    // handle.
    if (RegName.equals(/*STRINGREF_STR*/"rsp") || RegName.equals(/*STRINGREF_STR*/"rbp")) {
      // Check that the register size is 64-bit.
      HasSizeMismatch.$set(RegSize != 64);
      return true;
    }
    
    // Check if the register is a 32-bit register the backend can handle.
    return super.validateGlobalRegisterVariable(new StringRef(RegName), RegSize, 
        HasSizeMismatch);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetInfo::~X86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4312,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3970,
   FQN="(anonymous namespace)::X86_64TargetInfo::~X86_64TargetInfo", NM="_ZN12_GLOBAL__N_116X86_64TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_64TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
