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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;


/// Emits the copy/dispose helpers for a __block variable with a
/// nontrivial copy constructor or destructor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1760,
 FQN="(anonymous namespace)::CXXByrefHelpers", NM="_ZN12_GLOBAL__N_115CXXByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpersE")
//</editor-fold>
public final class CXXByrefHelpers extends /*public*/ BlockByrefHelpers implements Destructors.ClassWithDestructor {
  private QualType VarType;
  private /*const*/ Expr /*P*/ CopyExpr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::CXXByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1765,
   FQN="(anonymous namespace)::CXXByrefHelpers::CXXByrefHelpers", NM="_ZN12_GLOBAL__N_115CXXByrefHelpersC1EN5clang9CharUnitsENS1_8QualTypeEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpersC1EN5clang9CharUnitsENS1_8QualTypeEPKNS1_4ExprE")
  //</editor-fold>
  public CXXByrefHelpers(CharUnits alignment, QualType type, 
      /*const*/ Expr /*P*/ copyExpr) {
    // : BlockByrefHelpers(alignment), VarType(type), CopyExpr(copyExpr) 
    //START JInit
    super(new CharUnits(alignment));
    this.VarType = new QualType(type);
    this.CopyExpr = copyExpr;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::needsCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1769,
   FQN="(anonymous namespace)::CXXByrefHelpers::needsCopy", NM="_ZNK12_GLOBAL__N_115CXXByrefHelpers9needsCopyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK12_GLOBAL__N_115CXXByrefHelpers9needsCopyEv")
  //</editor-fold>
  @Override public boolean needsCopy() /*const*//* override*/ {
    return CopyExpr != null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::emitCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1770,
   FQN="(anonymous namespace)::CXXByrefHelpers::emitCopy", NM="_ZN12_GLOBAL__N_115CXXByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_")
  //</editor-fold>
  @Override public void emitCopy(final CodeGenFunction /*&*/ CGF, Address destField, 
          Address srcField)/* override*/ {
    if (!(CopyExpr != null)) {
      return;
    }
    CGF.EmitSynthesizedCXXCopyCtor(new Address(destField), new Address(srcField), CopyExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::emitDispose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1776,
   FQN="(anonymous namespace)::CXXByrefHelpers::emitDispose", NM="_ZN12_GLOBAL__N_115CXXByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public void emitDispose(final CodeGenFunction /*&*/ CGF, Address field)/* override*/ {
    EHScopeStack.stable_iterator cleanupDepth = CGF.EHStack.stable_begin();
    CGF.PushDestructorCleanup(new QualType(VarType), new Address(field));
    CGF.PopCleanupBlocks(new EHScopeStack.stable_iterator(cleanupDepth));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::profileImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1782,
   FQN="(anonymous namespace)::CXXByrefHelpers::profileImpl", NM="_ZNK12_GLOBAL__N_115CXXByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK12_GLOBAL__N_115CXXByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void profileImpl(final FoldingSetNodeID /*&*/ id) /*const*//* override*/ {
    id.AddPointer(VarType.getCanonicalType().getAsOpaquePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::CXXByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1760,
   FQN="(anonymous namespace)::CXXByrefHelpers::CXXByrefHelpers", NM="_ZN12_GLOBAL__N_115CXXByrefHelpersC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpersC1EOS0_")
  //</editor-fold>
  public /*inline*/ CXXByrefHelpers(JD$Move _dparam, final CXXByrefHelpers /*&&*/$Prm0) {
    // : BlockByrefHelpers(static_cast<CXXByrefHelpers &&>()), VarType(static_cast<CXXByrefHelpers &&>().VarType), CopyExpr(static_cast<CXXByrefHelpers &&>().CopyExpr) 
    //START JInit
    super($Prm0);
    this.VarType = new QualType(JD$Move.INSTANCE, $Prm0.VarType);
    this.CopyExpr = $Prm0.CopyExpr;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXByrefHelpers::~CXXByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1760,
   FQN="(anonymous namespace)::CXXByrefHelpers::~CXXByrefHelpers", NM="_ZN12_GLOBAL__N_115CXXByrefHelpersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_115CXXByrefHelpersD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static CXXByrefHelpers $factory(CXXByrefHelpers p) { return new CXXByrefHelpers(JD$Move.INSTANCE, p); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "VarType=" + VarType // NOI18N
              + ", CopyExpr=" + "[Expr]" // NOI18N
              + super.toString(); // NOI18N
  }
}
