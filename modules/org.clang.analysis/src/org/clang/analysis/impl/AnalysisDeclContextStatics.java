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
package org.clang.analysis.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import static org.clang.analysis.impl.AnalysisDeclContextStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisDeclContextStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZL10isSelfDeclPKN5clang7VarDeclE;_ZL11getBodyFarmRN5clang10ASTContextEPNS_12CodeInjectorE;_ZL27addParentsForSyntheticStmtsPKN5clang3CFGERNS_9ParentMapE;_ZL29LazyInitializeReferencedDeclsPKN5clang9BlockDeclERPvRN4llvm20BumpPtrAllocatorImplINS5_15MallocAllocatorELj4096ELj4096EEE; -static-type=AnalysisDeclContextStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class AnalysisDeclContextStatics {

//<editor-fold defaultstate="collapsed" desc="getBodyFarm">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 88,
 FQN="getBodyFarm", NM="_ZL11getBodyFarmRN5clang10ASTContextEPNS_12CodeInjectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZL11getBodyFarmRN5clang10ASTContextEPNS_12CodeInjectorE")
//</editor-fold>
public static BodyFarm /*&*/ getBodyFarm(AnalysisDeclContextManager Manager, final ASTContext /*&*/ C) {
  final/*static*/ BodyFarm /*P*/ BF = getBodyFarm$$.getBodyFarm(Manager, C);
  return $Deref(BF);
}
private static final class getBodyFarm$$ {
  // JAVA: must not be static, that's why logic was moved into AnalysisDeclContextManager
  // static final/*static*/ BodyFarm /*P*/ BF = new BodyFarm(C, injector);
  private static BodyFarm/*P*/ getBodyFarm(final AnalysisDeclContextManager Owner, final ASTContext /*&*/ C) {
    BodyFarm/*P*/ BF = (BodyFarm/*P*/) Owner.$getBodyFarm(C);
    assert BF != null;
    return BF;
  }
}


/// Returns true if \param VD is an Objective-C implicit 'self' parameter.
//<editor-fold defaultstate="collapsed" desc="isSelfDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 145,
 FQN="isSelfDecl", NM="_ZL10isSelfDeclPKN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZL10isSelfDeclPKN5clang7VarDeclE")
//</editor-fold>
public static boolean isSelfDecl(/*const*/ VarDecl /*P*/ VD) {
  return isa_ImplicitParamDecl(VD) && $eq_StringRef(VD.getName(), /*STRINGREF_STR*/"self");
}


/// Add each synthetic statement in the CFG to the parent map, using the
/// source statement's parent.
//<editor-fold defaultstate="collapsed" desc="addParentsForSyntheticStmts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 203,
 FQN="addParentsForSyntheticStmts", NM="_ZL27addParentsForSyntheticStmtsPKN5clang3CFGERNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZL27addParentsForSyntheticStmtsPKN5clang3CFGERNS_9ParentMapE")
//</editor-fold>
public static void addParentsForSyntheticStmts(/*const*/ CFG /*P*/ TheCFG, final ParentMap /*&*/ PM) {
  if (!(TheCFG != null)) {
    return;
  }
  
  for (DenseMapIterator</*const*/ DeclStmt /*P*/ , /*const*/ DeclStmt /*P*/ > I = TheCFG.synthetic_stmt_begin(), 
      E = TheCFG.synthetic_stmt_end();
       I.$noteq(E); I.$preInc()) {
    PM.setParent(I.$arrow().first, PM.getParent_Stmt$C$P(I.$arrow().second));
  }
}

//<editor-fold defaultstate="collapsed" desc="LazyInitializeReferencedDecls">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 552,
 FQN="LazyInitializeReferencedDecls", NM="_ZL29LazyInitializeReferencedDeclsPKN5clang9BlockDeclERPvRN4llvm20BumpPtrAllocatorImplINS5_15MallocAllocatorELj4096ELj4096EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZL29LazyInitializeReferencedDeclsPKN5clang9BlockDeclERPvRN4llvm20BumpPtrAllocatorImplINS5_15MallocAllocatorELj4096ELj4096EEE")
//</editor-fold>
public static BumpVector</*const*/ VarDecl /*P*/ > /*P*/ LazyInitializeReferencedDecls(/*const*/ BlockDecl /*P*/ BD, 
                             final type$ref<Object>/*void P&*/ Vec, 
                             final BumpPtrAllocatorImpl /*&*/ A) {
  BumpVectorContext BC = null;
  FindBlockDeclRefExprsVals F = null;
  try {
    if ((Vec.$deref() != null)) {
      return (BumpVector</*const*/ VarDecl /*P*/ > /*P*/ )Vec.$deref();
    }
    
    BC/*J*/= new BumpVectorContext(A);
    final BumpVectorContext $BC = BC;
    // JAVA: MEMORY
    BumpVector</*const*/ VarDecl /*P*/ > /*P*/ BV = (BumpVector</*const*/ VarDecl /*P*/ > /*P*/ )A.Allocate$T(BumpVector.class);
    /*NEW_EXPR [System]*/BV = /*new (BV)*/ $new_uint_voidPtr(BV, (type$ptr<?> New$Mem)->{
        return new BumpVector</*const*/ VarDecl /*P*/ >(
                new BumpVector.TypeAllocator<VarDecl>(
                (int size)->{return new VarDecl[size];}), $BC, 10);
     });
    
    // Go through the capture list.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : BD.captures()) {
      BV.push_back(CI.getVariable(), BC);
    }
    
    // Find the referenced global/static variables.
    F/*J*/= new FindBlockDeclRefExprsVals($Deref(BV), BC);
    F.Visit(BD.getBody());
    
    Vec.$set(BV);
    return BV;
  } finally {
    if (F != null) { F.$destroy(); }
    if (BC != null) { BC.$destroy(); }
  }
}

} // END OF class AnalysisDeclContextStatics
