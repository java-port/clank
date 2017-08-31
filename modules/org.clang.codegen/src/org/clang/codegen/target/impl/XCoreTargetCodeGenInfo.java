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

package org.clang.codegen.target.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::XCoreTargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7320,
 FQN="(anonymous namespace)::XCoreTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoE")
//</editor-fold>
public class XCoreTargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
  private /*mutable */TypeStringCache TSC;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::XCoreTargetCodeGenInfo::XCoreTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7323,
   FQN="(anonymous namespace)::XCoreTargetCodeGenInfo::XCoreTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public XCoreTargetCodeGenInfo(final CodeGenTypes /*&*/ CGT) {
    // : TargetCodeGenInfo(new XCoreABIInfo(CGT)), TSC() 
    //START JInit
    super(new XCoreABIInfo(CGT));
    this.TSC = new TypeStringCache();
    //END JInit
  }

  
  /// XCore uses emitTargetMD to emit TypeString metadata for global symbols.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::XCoreTargetCodeGenInfo::emitTargetMD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7491,
   FQN="(anonymous namespace)::XCoreTargetCodeGenInfo::emitTargetMD", NM="_ZNK12_GLOBAL__N_122XCoreTargetCodeGenInfo12emitTargetMDEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122XCoreTargetCodeGenInfo12emitTargetMDEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void emitTargetMD(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
              final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    SmallString/*128*/ Enc/*J*/= new SmallString/*128*/(128);
    if (getTypeString(Enc, D, CGM, TSC)) {
      final LLVMContext /*&*/ Ctx = CGM.getModule().getContext();
      Metadata /*P*/ MDVals[/*2*/] = new Metadata /*P*/  [/*2*/] {
        ConstantAsMetadata.get(GV), 
        MDString.get(Ctx, Enc.str())};
      NamedMDNode /*P*/ MD = CGM.getModule().getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"xcore.typestrings"));
      MD.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(MDVals, true)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::XCoreTargetCodeGenInfo::~XCoreTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7320,
   FQN="(anonymous namespace)::XCoreTargetCodeGenInfo::~XCoreTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122XCoreTargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TSC.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TSC=" + TSC // NOI18N
              + super.toString(); // NOI18N
  }
}
