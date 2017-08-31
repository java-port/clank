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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6896,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6291,
 FQN="(anonymous namespace)::MSP430TargetInfo", NM="_ZN12_GLOBAL__N_116MSP430TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116MSP430TargetInfoE")
//</editor-fold>
public class MSP430TargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*16*/] {
    $("r0"), $("r1"), $("r2"), $("r3"), $("r4"), $("r5"), $("r6"), $("r7"), 
    $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("r13"), $("r14"), $("r15")});
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::MSP430TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6900,
   FQN="(anonymous namespace)::MSP430TargetInfo::MSP430TargetInfo", NM="_ZN12_GLOBAL__N_116MSP430TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116MSP430TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public MSP430TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple)*/ 
    //START JInit
    super(Triple);
    //END JInit
    BigEndian = false;
    TLSSupported = false;
    IntWidth = 16;
    IntAlign = 16;
    LongWidth = 32;
    LongLongWidth = 64;
    LongAlign = LongLongAlign = 16;
    PointerWidth = 16;
    PointerAlign = 16;
    SuitableAlign = 16;
    SizeType = IntType.UnsignedInt;
    IntMaxType = IntType.SignedLongLong;
    IntPtrType = IntType.SignedInt;
    PtrDiffType = IntType.SignedInt;
    SigAtomicType = IntType.SignedLong;
    resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:e-p:16:16-i32:16:32-a:16-n8:16"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6919,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6313,
   FQN="(anonymous namespace)::MSP430TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"MSP430"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__MSP430__"));
    // FIXME: defines for different 'flavours' of MCU
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6925,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6319,
   FQN="(anonymous namespace)::MSP430TargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    // FIXME: Implement.
    // JAVA: can not use None() here, because it is used in $assignMove
    return new ArrayRef<Builtin.Info>(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6929,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6323,
   FQN="(anonymous namespace)::MSP430TargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"msp430");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6963,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6357,
   FQN="(anonymous namespace)::MSP430TargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6933,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6327,
   FQN="(anonymous namespace)::MSP430TargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    // No aliases.
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6937,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6331,
   FQN="(anonymous namespace)::MSP430TargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ info) /*const*//* override*/ {
    // FIXME: implement
    switch (Name.$star()) {
     case 'K': // the constant 1
     case 'L': // constant -1^20 .. 1^19
     case 'M': // constant 1-4:
      return true;
    }
    // No target constraints for now.
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6949,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6343,
   FQN="(anonymous namespace)::MSP430TargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // FIXME: Is this really right?
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6953,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6347,
   FQN="(anonymous namespace)::MSP430TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_116MSP430TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116MSP430TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    // FIXME: implement
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSP430TargetInfo::~MSP430TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6896,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6291,
   FQN="(anonymous namespace)::MSP430TargetInfo::~MSP430TargetInfo", NM="_ZN12_GLOBAL__N_116MSP430TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116MSP430TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
