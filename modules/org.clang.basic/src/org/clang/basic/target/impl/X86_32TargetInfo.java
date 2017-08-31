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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;


// X86-32 generic target
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3992,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3652,
 FQN="(anonymous namespace)::X86_32TargetInfo", NM="_ZN12_GLOBAL__N_116X86_32TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_32TargetInfoE")
//</editor-fold>
public class X86_32TargetInfo extends /*public*/ X86TargetInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo::X86_32TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3994,
   FQN="(anonymous namespace)::X86_32TargetInfo::X86_32TargetInfo", NM="_ZN12_GLOBAL__N_116X86_32TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_32TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public X86_32TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : X86TargetInfo(Triple, Opts)*/ 
    //START JInit
    super(Triple, Opts);
    //END JInit
    DoubleAlign = LongLongAlign = 32;
    LongDoubleWidth = 96;
    LongDoubleAlign = 32;
    SuitableAlign = $int2uchar(128);
    resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:e-p:32:32-f64:32:64-f80:32-n8:16:32-S128"));
    SizeType = IntType.UnsignedInt;
    PtrDiffType = IntType.SignedInt;
    IntPtrType = IntType.SignedInt;
    RegParmMax = 3;
    
    // Use fpret for all types.
    RealTypeUsesObjCFPRet =  (byte) ((1 << TargetInfo.RealType.Float.getValue())
       | (1 << TargetInfo.RealType.Double.getValue())
       | (1 << TargetInfo.RealType.LongDouble.getValue()));
    
    // x86-32 has atomics up to 8 bytes
    // FIXME: Check that we actually have cmpxchg8b before setting
    // MaxAtomicInlineWidth. (cmpxchg8b is an i586 instruction.)
    MaxAtomicPromoteWidth = MaxAtomicInlineWidth = 64;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4016,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3675,
   FQN="(anonymous namespace)::X86_32TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_116X86_32TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_32TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4020,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3679,
   FQN="(anonymous namespace)::X86_32TargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_116X86_32TargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_32TargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 0;
    }
    if (RegNo == 1) {
      return 2;
    }
    return -1;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo::validateOperandSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4025,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3684,
   FQN="(anonymous namespace)::X86_32TargetInfo::validateOperandSize", NM="_ZNK12_GLOBAL__N_116X86_32TargetInfo19validateOperandSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116X86_32TargetInfo19validateOperandSizeEN4llvm9StringRefEj")
  //</editor-fold>
  @Override public boolean validateOperandSize(StringRef Constraint, 
                     /*uint*/int Size) /*const*//* override*/ {
    switch (Constraint.$at(0)) {
     default:
      break;
     case 'R':
     case 'q':
     case 'Q':
     case 'a':
     case 'b':
     case 'c':
     case 'd':
     case 'S':
     case 'D':
      return $lesseq_uint(Size, 32);
     case 'A':
      return $lesseq_uint(Size, 64);
    }
    
    return super.validateOperandSize(/*NO_COPY*/Constraint, Size);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetInfo::~X86_32TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3992,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3652,
   FQN="(anonymous namespace)::X86_32TargetInfo::~X86_32TargetInfo", NM="_ZN12_GLOBAL__N_116X86_32TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116X86_32TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
