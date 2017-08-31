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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;

//<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 35,
 FQN="clang::ObjCListBase", NM="_ZN5clang12ObjCListBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCListBaseE")
//</editor-fold>
public class ObjCListBase<T> {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::ObjCListBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 36,
   FQN="clang::ObjCListBase::ObjCListBase", NM="_ZN5clang12ObjCListBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCListBaseC1ERKS0_")
  //</editor-fold>
  private ObjCListBase(final /*const*/ ObjCListBase /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 37,
   FQN="clang::ObjCListBase::operator=", NM="_ZN5clang12ObjCListBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCListBaseaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ ObjCListBase /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  /// List is an array of pointers to objects that are not owned by this object.
  protected type$ptr<Object>/*void PP*/ List;
  protected /*uint*/int NumElts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::ObjCListBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*null ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 44,
   FQN="clang::ObjCListBase::ObjCListBase", NM="_ZN5clang12ObjCListBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCListBaseC1Ev")
  //</editor-fold>
  public ObjCListBase() {
    // : List(null), NumElts(0) 
    //START JInit
    this.List = create_type$ptr((Object[])null);;
    this.NumElts = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 45,
   FQN="clang::ObjCListBase::size", NM="_ZNK5clang12ObjCListBase4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCListBase4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumElts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 46,
   FQN="clang::ObjCListBase::empty", NM="_ZNK5clang12ObjCListBase5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCListBase5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return NumElts == 0;
  }

/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // ObjCListBase
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCListBase::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 27,
   FQN="clang::ObjCListBase::set", NM="_ZN5clang12ObjCListBase3setEPKPvjRNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCListBase3setEPKPvjRNS_10ASTContextE")
  //</editor-fold>
  protected void set(type$ptr<T>/*void P const P*/ InList, /*uint*/int Elts, final ASTContext /*&*/ Ctx) {
    List = create_type$ptr((Object[])null);
    if (Elts == 0) {
      return; // Setting to an empty list is a noop.
    }
    
    List = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Ctx)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Object/*void P*/ [Elts]);
    NumElts = Elts;
    memcpy(List, InList, /*JAVA*/(true ? 1 : $sizeof_ptr(/*Object */)) * Elts, true);
  }

  
  @Override public String toString() {
    return "" + "List=" + List // NOI18N
              + ", NumElts=" + NumElts; // NOI18N
  }
}
