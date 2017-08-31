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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;

//<editor-fold defaultstate="collapsed" desc="clang::StmtIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed type$ptr to pure Stmt P */,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 121,
 FQN="clang::StmtIterator", NM="_ZN5clang12StmtIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorE")
//</editor-fold>
public class/*struct*/ StmtIterator extends /*public*/ StmtIteratorImpl<StmtIterator, /*type$ptr */Stmt /*P*/ /*&*/ > {
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 122,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1Ev")
  //</editor-fold>
  public /*explicit*/ StmtIterator() {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >() 
    //START JInit
    super();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 124,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1EPPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1EPPNS_4StmtE")
  //</editor-fold>
  public StmtIterator(Stmt /*P*/ /*P*/ S[]) {
    this(create_type$ptr(S));
  }
  public StmtIterator(Stmt /*P*/ /*P*/ S[], int index) {
    this(create_type$ptr(S, index));
  }
  public StmtIterator(type$iterator<?, Stmt /*P*/ /*P*/> S) {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >(S) 
    //START JInit
    super(S);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 126,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1EPPNS_4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1EPPNS_4DeclES3_")
  //</editor-fold>
  public StmtIterator(type$iterator<?, Decl /*P*/ /*P*/> dgi, type$ptr<Decl /*P*/ /*P*/> dge) {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >(dgi, dge) 
    //START JInit
    super(dgi, dge);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 129,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1EPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1EPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public StmtIterator(/*const*/ VariableArrayType /*P*/ t) {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >(t) 
    //START JInit
    super(t);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 121,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StmtIterator(final /*const*/ StmtIterator /*&*/ $Prm0) {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >() 
    //START JInit
    super((StmtIteratorBase)$Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::StmtIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 121,
   FQN="clang::StmtIterator::StmtIterator", NM="_ZN5clang12StmtIteratorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratorC1EOS0_")
  //</editor-fold>
  public /*inline*/ StmtIterator(JD$Move _dparam, final StmtIterator /*&&*/$Prm0) {
    // : StmtIteratorImpl<StmtIterator, Stmt * & >(static_cast<StmtIterator &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIterator::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 121,
   FQN="clang::StmtIterator::operator=", NM="_ZN5clang12StmtIteratoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang12StmtIteratoraSERKS0_")
  //</editor-fold>
  public /*inline*/ StmtIterator /*&*/ $assign(final /*const*/ StmtIterator /*&*/ $Prm0) {
    /*Deref*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override  public StmtIterator clone() { return new StmtIterator(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
