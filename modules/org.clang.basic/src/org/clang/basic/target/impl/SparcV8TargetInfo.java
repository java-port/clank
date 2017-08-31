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


// SPARC v8 is the 32-bit mode selected by Triple::sparc.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV8TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6601,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6030,
 FQN="(anonymous namespace)::SparcV8TargetInfo", NM="_ZN12_GLOBAL__N_117SparcV8TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SparcV8TargetInfoE")
//</editor-fold>
public class SparcV8TargetInfo extends /*public*/ SparcTargetInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV8TargetInfo::SparcV8TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6603,
   FQN="(anonymous namespace)::SparcV8TargetInfo::SparcV8TargetInfo", NM="_ZN12_GLOBAL__N_117SparcV8TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SparcV8TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public SparcV8TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : SparcTargetInfo(Triple, Opts)*/ 
    //START JInit
    super(Triple, Opts);
    //END JInit
    resetDataLayout(new StringRef(/*KEEP_STR*/"E-m:e-p:32:32-i64:64-f128:64-n32-S64"));
    // NetBSD / OpenBSD use long (same as llvm default); everyone else uses int.
    switch (getTriple().getOS()) {
     default:
      SizeType = IntType.UnsignedInt;
      IntPtrType = IntType.SignedInt;
      PtrDiffType = IntType.SignedInt;
      break;
     case NetBSD:
     case OpenBSD:
      SizeType = IntType.UnsignedLong;
      IntPtrType = IntType.SignedLong;
      PtrDiffType = IntType.SignedLong;
      break;
    }
    MaxAtomicPromoteWidth = MaxAtomicInlineWidth = 64;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV8TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6623,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6050,
   FQN="(anonymous namespace)::SparcV8TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_117SparcV8TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SparcV8TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    super.getTargetDefines(Opts, Builder);
    switch (getCPUGeneration(CPU)) {
     case CG_V8:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__sparcv8"));
      if (getTriple().getOS() != Triple.OSType.Solaris) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__sparcv8__"));
      }
      break;
     case CG_V9:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__sparcv9"));
      if (getTriple().getOS() != Triple.OSType.Solaris) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__sparcv9__"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__sparc_v9__"));
      }
      break;
    }
    if (getTriple().getVendor() == Triple.VendorType.Myriad) {
      switch (CPU) {
       case CK_MYRIAD2_1:
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__myriad2"), new Twine(/*KEEP_STR*/$1));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__myriad2__"), new Twine(/*KEEP_STR*/$1));
        break;
       case CK_MYRIAD2_2:
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__myriad2"), new Twine(/*KEEP_STR*/$2));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__myriad2__"), new Twine(/*KEEP_STR*/$2));
        break;
       default:
        break;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV8TargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6656,
   FQN="(anonymous namespace)::SparcV8TargetInfo::hasSjLjLowering", NM="_ZNK12_GLOBAL__N_117SparcV8TargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SparcV8TargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  @Override public boolean hasSjLjLowering() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV8TargetInfo::~SparcV8TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6601,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6030,
   FQN="(anonymous namespace)::SparcV8TargetInfo::~SparcV8TargetInfo", NM="_ZN12_GLOBAL__N_117SparcV8TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SparcV8TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
