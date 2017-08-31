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

package org.clang.sema;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clank.support.Native.NativePOD;


/// \brief a linked list of methods with the same selector name but different
/// signatures.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 26,
 FQN="clang::ObjCMethodList", NM="_ZN5clang14ObjCMethodListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodListE")
//</editor-fold>
public class/*struct*/ ObjCMethodList implements NativePOD<ObjCMethodList> {
  // NOTE: If you add any members to this struct, make sure to serialize them.
  /// \brief If there is more than one decl with this signature.
  public PointerIntPair<ObjCMethodDecl /*P*/ > MethodAndHasMoreThanOneDecl;
  /// \brief The next list object and 2 bits for extra info.
  public PointerIntPair<ObjCMethodList /*P*/ > NextAndExtraBits;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::ObjCMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 33,
   FQN="clang::ObjCMethodList::ObjCMethodList", NM="_ZN5clang14ObjCMethodListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodListC1Ev")
  //</editor-fold>
  public ObjCMethodList() {
    // : MethodAndHasMoreThanOneDecl(), NextAndExtraBits() 
    //START JInit
    this.MethodAndHasMoreThanOneDecl = new PointerIntPair<ObjCMethodDecl /*P*/ >();
    this.NextAndExtraBits = new PointerIntPair<ObjCMethodList /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::ObjCMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 34,
   FQN="clang::ObjCMethodList::ObjCMethodList", NM="_ZN5clang14ObjCMethodListC1EPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodListC1EPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public ObjCMethodList(ObjCMethodDecl /*P*/ M) {
    // : MethodAndHasMoreThanOneDecl(M, 0), NextAndExtraBits() 
    //START JInit
    this.MethodAndHasMoreThanOneDecl = new PointerIntPair<ObjCMethodDecl /*P*/ >(M, 0);
    this.NextAndExtraBits = new PointerIntPair<ObjCMethodList /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::ObjCMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 36,
   FQN="clang::ObjCMethodList::ObjCMethodList", NM="_ZN5clang14ObjCMethodListC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodListC1ERKS0_")
  //</editor-fold>
  public ObjCMethodList(final /*const*/ ObjCMethodList /*&*/ L) {
    // : MethodAndHasMoreThanOneDecl(L.MethodAndHasMoreThanOneDecl), NextAndExtraBits(L.NextAndExtraBits) 
    //START JInit
    this.MethodAndHasMoreThanOneDecl = new PointerIntPair<ObjCMethodDecl /*P*/ >(L.MethodAndHasMoreThanOneDecl);
    this.NextAndExtraBits = new PointerIntPair<ObjCMethodList /*P*/ >(L.NextAndExtraBits);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 40,
   FQN="clang::ObjCMethodList::getNext", NM="_ZNK5clang14ObjCMethodList7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang14ObjCMethodList7getNextEv")
  //</editor-fold>
  public ObjCMethodList /*P*/ getNext() /*const*/ {
    return NextAndExtraBits.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::getBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 41,
   FQN="clang::ObjCMethodList::getBits", NM="_ZNK5clang14ObjCMethodList7getBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang14ObjCMethodList7getBitsEv")
  //</editor-fold>
  public /*uint*/int getBits() /*const*/ {
    return NextAndExtraBits.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::setNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 42,
   FQN="clang::ObjCMethodList::setNext", NM="_ZN5clang14ObjCMethodList7setNextEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodList7setNextEPS0_")
  //</editor-fold>
  public void setNext(ObjCMethodList /*P*/ L) {
    NextAndExtraBits.setPointer(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::setBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 43,
   FQN="clang::ObjCMethodList::setBits", NM="_ZN5clang14ObjCMethodList7setBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodList7setBitsEj")
  //</editor-fold>
  public void setBits(/*uint*/int B) {
    NextAndExtraBits.setInt(B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::getMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 45,
   FQN="clang::ObjCMethodList::getMethod", NM="_ZNK5clang14ObjCMethodList9getMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang14ObjCMethodList9getMethodEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getMethod() /*const*/ {
    return MethodAndHasMoreThanOneDecl.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::setMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 48,
   FQN="clang::ObjCMethodList::setMethod", NM="_ZN5clang14ObjCMethodList9setMethodEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodList9setMethodEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void setMethod(ObjCMethodDecl /*P*/ M) {
    MethodAndHasMoreThanOneDecl.setPointer(M);
    return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::hasMoreThanOneDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 52,
   FQN="clang::ObjCMethodList::hasMoreThanOneDecl", NM="_ZNK5clang14ObjCMethodList18hasMoreThanOneDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang14ObjCMethodList18hasMoreThanOneDeclEv")
  //</editor-fold>
  public boolean hasMoreThanOneDecl() /*const*/ {
    return (MethodAndHasMoreThanOneDecl.getInt() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::setHasMoreThanOneDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 55,
   FQN="clang::ObjCMethodList::setHasMoreThanOneDecl", NM="_ZN5clang14ObjCMethodList21setHasMoreThanOneDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodList21setHasMoreThanOneDeclEb")
  //</editor-fold>
  public void setHasMoreThanOneDecl(boolean B) {
    MethodAndHasMoreThanOneDecl.setInt((B ? 1 : 0));
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ObjCMethodList.h", line = 26,
   FQN="clang::ObjCMethodList::operator=", NM="_ZN5clang14ObjCMethodListaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang14ObjCMethodListaSERKS0_")
  //</editor-fold>
  public /*inline*/ ObjCMethodList /*&*/ $assign(final /*const*/ ObjCMethodList /*&*/ $Prm0) {
    this.MethodAndHasMoreThanOneDecl.$assign($Prm0.MethodAndHasMoreThanOneDecl);
    this.NextAndExtraBits.$assign($Prm0.NextAndExtraBits);
    return /*Deref*/this;
  }

  @Override public ObjCMethodList clone() {
    return new ObjCMethodList(this);
  }
  
  @Override public String toString() {
    return "" + "MethodAndHasMoreThanOneDecl=" + MethodAndHasMoreThanOneDecl // NOI18N
              + ", NextAndExtraBits=" + NextAndExtraBits; // NOI18N
  }
}
