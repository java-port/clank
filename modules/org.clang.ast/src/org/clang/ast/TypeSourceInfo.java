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
import static org.clank.support.Native.*;


/// \brief A container of type source information.
///
/// A client can read the relevant info using TypeLoc wrappers, e.g:
/// @code
/// TypeLoc TL = TypeSourceInfo->getTypeLoc();
/// TL.getStartLoc().print(OS, SrcMgr);
/// @endcode
///
//<editor-fold defaultstate="collapsed" desc="clang::TypeSourceInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*replacement for this+1*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 62,
 FQN="clang::TypeSourceInfo", NM="_ZN5clang14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14TypeSourceInfoE")
//</editor-fold>
public class TypeSourceInfo {
  private QualType Ty;
  public final type$ptr<?> $this$plus$1$TypeLocData; // JAVA: replacement for this+1
  // Contains a memory block after the class, used for type source information,
  // allocated by ASTContext.
  /*friend  class ASTContext*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSourceInfo::TypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 67,
   FQN="clang::TypeSourceInfo::TypeSourceInfo", NM="_ZN5clang14TypeSourceInfoC1ENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14TypeSourceInfoC1ENS_8QualTypeE")
  //</editor-fold>
  /*friend*//*private*/ TypeSourceInfo(QualType ty, final type$ptr<?> $this$plus$1$TypeLocData) {
    // : Ty(ty) 
    //START JInit
    this.Ty = new QualType(ty);
    //END JInit
    this.$this$plus$1$TypeLocData = $toConst($this$plus$1$TypeLocData);
  }

/*public:*/
  /// \brief Return the type wrapped by this type source info.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSourceInfo::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 70,
   FQN="clang::TypeSourceInfo::getType", NM="_ZNK5clang14TypeSourceInfo7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14TypeSourceInfo7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(Ty);
  }

  
  /// \brief Return the TypeLoc wrapper for the type source info.
  
  /// \brief Return the TypeLoc for a type source info.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSourceInfo::getTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*replacement for this+1*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 215,
   FQN="clang::TypeSourceInfo::getTypeLoc", NM="_ZNK5clang14TypeSourceInfo10getTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14TypeSourceInfo10getTypeLocEv")
  //</editor-fold>
  public /*inline*/ TypeLoc getTypeLoc() /*const*/ {
    // TODO: is this alignment already sufficient?
    return new TypeLoc(/*NO_COPY*/Ty, $this$plus$1$TypeLocData);
  }
 // implemented in TypeLoc.h
  
  /// \brief Override the type stored in this TypeSourceInfo. Use with caution!
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSourceInfo::overrideType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 76,
   FQN="clang::TypeSourceInfo::overrideType", NM="_ZN5clang14TypeSourceInfo12overrideTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14TypeSourceInfo12overrideTypeENS_8QualTypeE")
  //</editor-fold>
  public void overrideType(QualType T) {
    Ty.$assign(T);
  }

  
  @Override public String toString() {
    return "TSI{" + Ty + "}"; // NOI18N
  }
}
