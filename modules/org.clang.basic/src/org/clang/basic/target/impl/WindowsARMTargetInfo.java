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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5495,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5114,
 FQN="(anonymous namespace)::WindowsARMTargetInfo", NM="_ZN12_GLOBAL__N_120WindowsARMTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_120WindowsARMTargetInfoE")
//</editor-fold>
public class WindowsARMTargetInfo extends /*public*/ WindowsTargetInfo<ARMleTargetInfo> implements Destructors.ClassWithDestructor {
  private /*const*/ Triple _Triple;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo::WindowsARMTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5498,
   FQN="(anonymous namespace)::WindowsARMTargetInfo::WindowsARMTargetInfo", NM="_ZN12_GLOBAL__N_120WindowsARMTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_120WindowsARMTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public WindowsARMTargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : WindowsTargetInfo<ARMleTargetInfo>(Triple, Opts), Triple(Triple)*/ 
    //START JInit
    super(new ARMleTargetInfo(Triple, Opts), Triple, Opts);
    this._Triple = new Triple(Triple);
    //END JInit
    super.tgt.WCharType = IntType.UnsignedShort;
    super.tgt.SizeType = IntType.UnsignedInt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo::getVisualStudioDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5124,
   FQN="(anonymous namespace)::WindowsARMTargetInfo::getVisualStudioDefines", NM="_ZNK12_GLOBAL__N_120WindowsARMTargetInfo22getVisualStudioDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_120WindowsARMTargetInfo22getVisualStudioDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  public void getVisualStudioDefines(/*const*/ LangOptions /*&*/ Opts, 
                        MacroBuilder /*&*/ Builder) /*const*/ {
    super.getVisualStudioDefines(Opts, Builder);
    
    // FIXME: this is invalid for WindowsCE
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_ARM_NT"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_ARMT"), new Twine(/*KEEP_STR*/"_M_ARM"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_THUMB"), new Twine(/*KEEP_STR*/"_M_ARM"));
    assert ((_Triple.getArch() == Triple.ArchType.arm || _Triple.getArch() == Triple.ArchType.thumb)) : "invalid architecture for Windows ARM target info";
    /*uint*/int Offset = _Triple.getArch() == Triple.ArchType.arm ? 4 : 6;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_ARM"), new Twine(_Triple.getArchName().substr(Offset)));
    
    // TODO map the complete set of values
    // 31: VFPv3 40: VFPv4
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_ARM_FP"), new Twine(/*KEEP_STR*/"31"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5522,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5143,
   FQN="(anonymous namespace)::WindowsARMTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_120WindowsARMTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_120WindowsARMTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5525,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5146,
   FQN="(anonymous namespace)::WindowsARMTargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_120WindowsARMTargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_120WindowsARMTargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_X86StdCall:
     case CC_X86ThisCall:
     case CC_X86FastCall:
     case CC_X86VectorCall:
      return CallingConvCheckResult.CCCR_Ignore;
     case CC_C:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsARMTargetInfo::~WindowsARMTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5495,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5114,
   FQN="(anonymous namespace)::WindowsARMTargetInfo::~WindowsARMTargetInfo", NM="_ZN12_GLOBAL__N_120WindowsARMTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_120WindowsARMTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    _Triple.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Triple=" + _Triple // NOI18N
              + super.toString(); // NOI18N
  }
}
