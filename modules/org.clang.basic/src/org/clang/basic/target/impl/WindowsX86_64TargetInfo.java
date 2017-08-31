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
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;


// x86-64 Windows target
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4403,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4050,
 FQN="(anonymous namespace)::WindowsX86_64TargetInfo", NM="_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoE")
//</editor-fold>
public class WindowsX86_64TargetInfo extends /*public*/ WindowsTargetInfo<X86_64TargetInfo> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo::WindowsX86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4405,
   FQN="(anonymous namespace)::WindowsX86_64TargetInfo::WindowsX86_64TargetInfo", NM="_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public WindowsX86_64TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : WindowsTargetInfo<X86_64TargetInfo>(Triple, Opts)*/ 
    //START JInit
    super(new X86_64TargetInfo(Triple, Opts), Triple, Opts);
    //END JInit
    super.tgt.WCharType = IntType.UnsignedShort;
    super.tgt.LongWidth = super.tgt.LongAlign = 32;
    super.tgt.DoubleAlign = super.tgt.LongLongAlign = 64;
    super.tgt.IntMaxType = IntType.SignedLongLong;
    super.tgt.Int64Type = IntType.SignedLongLong;
    super.tgt.SizeType = IntType.UnsignedLongLong;
    super.tgt.PtrDiffType = IntType.SignedLongLong;
    super.tgt.IntPtrType = IntType.SignedLongLong;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4417,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4065,
   FQN="(anonymous namespace)::WindowsX86_64TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    super.getTargetDefines(Opts, Builder);
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_WIN64"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4423,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4071,
   FQN="(anonymous namespace)::WindowsX86_64TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4427,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4075,
   FQN="(anonymous namespace)::WindowsX86_64TargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123WindowsX86_64TargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_X86StdCall:
     case CC_X86ThisCall:
     case CC_X86FastCall:
      return CallingConvCheckResult.CCCR_Ignore;
     case CC_C:
     case CC_X86VectorCall:
     case CC_IntelOclBicc:
     case CC_X86_64SysV:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsX86_64TargetInfo::~WindowsX86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4403,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4050,
   FQN="(anonymous namespace)::WindowsX86_64TargetInfo::~WindowsX86_64TargetInfo", NM="_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123WindowsX86_64TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
