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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;


/// QualifierInfo - A struct with extended info about a syntactic
/// name qualifier, to be used for the case of out-of-line declarations.
//<editor-fold defaultstate="collapsed" desc="clang::QualifierInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 613,
 FQN="clang::QualifierInfo", NM="_ZN5clang13QualifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13QualifierInfoE")
//</editor-fold>
public class/*struct*/ QualifierInfo {
  public NestedNameSpecifierLoc QualifierLoc;
  
  /// NumTemplParamLists - The number of "outer" template parameter lists.
  /// The count includes all of the template parameter lists that were matched
  /// against the template-ids occurring into the NNS and possibly (in the
  /// case of an explicit specialization) a final "template <>".
  public /*uint*/int NumTemplParamLists;
  
  /// TemplParamLists - A new-allocated array of size NumTemplParamLists,
  /// containing pointers to the "outer" template parameter lists.
  /// It includes all of the template parameter lists that were matched
  /// against the template-ids occurring into the NNS and possibly (in the
  /// case of an explicit specialization) a final "template <>".
  public type$ptr<TemplateParameterList /*P*/ /*P*/> TemplParamLists;
  
  /// Default constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierInfo::QualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 630,
   FQN="clang::QualifierInfo::QualifierInfo", NM="_ZN5clang13QualifierInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13QualifierInfoC1Ev")
  //</editor-fold>
  public QualifierInfo() {
    // : QualifierLoc(), NumTemplParamLists(0), TemplParamLists(null) 
    //START JInit
    this.QualifierLoc = new NestedNameSpecifierLoc();
    this.NumTemplParamLists = 0;
    this.TemplParamLists = null;
    //END JInit
  }

  
  /// setTemplateParameterListsInfo - Sets info about "outer" template
  /// parameter lists.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierInfo::setTemplateParameterListsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1750,
   FQN="clang::QualifierInfo::setTemplateParameterListsInfo", NM="_ZN5clang13QualifierInfo29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13QualifierInfo29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE")
  //</editor-fold>
  public void setTemplateParameterListsInfo(final ASTContext /*&*/ Context, ArrayRef<TemplateParameterList /*P*/ > TPLists) {
    // Free previous template parameters (if any).
    if ($greater_uint(NumTemplParamLists, 0)) {
      Context.Deallocate(TemplParamLists);
      TemplParamLists = null;
      NumTemplParamLists = 0;
    }
    // Set info on matched template parameter lists (if any).
    if (!TPLists.empty()) {
      TemplParamLists = create_const_type$ptr(/*FIXME:NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (Context)*/ new TemplateParameterList /*P*/ [TPLists.size()]);
      NumTemplParamLists = TPLists.size();
      std.copy(TPLists.begin(), TPLists.end(), TemplParamLists);
    }
  }

/*private:*/
  // Copy constructor and copy assignment are disabled.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierInfo::QualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 640,
   FQN="clang::QualifierInfo::QualifierInfo", NM="_ZN5clang13QualifierInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13QualifierInfoC1ERKS0_")
  //</editor-fold>
  private QualifierInfo(final /*const*/ QualifierInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::QualifierInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 641,
   FQN="clang::QualifierInfo::operator=", NM="_ZN5clang13QualifierInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13QualifierInfoaSERKS0_")
  //</editor-fold>
  private QualifierInfo /*&*/ $assign(final /*const*/ QualifierInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "QualifierLoc=" + QualifierLoc // NOI18N
              + ", NumTemplParamLists=" + NumTemplParamLists // NOI18N
              + ", TemplParamLists=" + TemplParamLists; // NOI18N
  }
}
