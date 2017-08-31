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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinAArch64TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6031,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5632,
 FQN="(anonymous namespace)::DarwinAArch64TargetInfo", NM="_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoE")
//</editor-fold>
public class DarwinAArch64TargetInfo extends /*public*/ DarwinTargetInfo<AArch64leTargetInfo> implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinAArch64TargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6033,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5634,
   FQN="(anonymous namespace)::DarwinAArch64TargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_123DarwinAArch64TargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123DarwinAArch64TargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override protected void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__AARCH64_SIMD__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM64_ARCH_8__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__LITTLE_ENDIAN__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__arm64"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__arm64__"), new Twine(/*KEEP_STR*/$1));
    
    getDarwinDefines(Builder, Opts, Triple, super.tgt.PlatformName, super.tgt.PlatformMinVersion);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinAArch64TargetInfo::DarwinAArch64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6047,
   FQN="(anonymous namespace)::DarwinAArch64TargetInfo::DarwinAArch64TargetInfo", NM="_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public DarwinAArch64TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : DarwinTargetInfo<AArch64leTargetInfo>(Triple, Opts)*/ 
    //START JInit
    super(new AArch64leTargetInfo(Triple, Opts), Triple, Opts);
    //END JInit
    super.tgt.Int64Type = IntType.SignedLongLong;
    super.tgt.WCharType = IntType.SignedInt;
    super.tgt.UseSignedCharForObjCBool = false;
    
    super.tgt.LongDoubleWidth = super.tgt.LongDoubleAlign = super.tgt.SuitableAlign = 64;
    super.tgt.LongDoubleFormat = $AddrOf(APFloat.IEEEdouble);
    
    super.tgt.TheCXXABI.set(TargetCXXABI.Kind.iOS64);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinAArch64TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6059,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5660,
   FQN="(anonymous namespace)::DarwinAArch64TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_123DarwinAArch64TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123DarwinAArch64TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinAArch64TargetInfo::~DarwinAArch64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6031,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5632,
   FQN="(anonymous namespace)::DarwinAArch64TargetInfo::~DarwinAArch64TargetInfo", NM="_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123DarwinAArch64TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
