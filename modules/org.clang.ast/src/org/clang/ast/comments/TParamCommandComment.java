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

package org.clang.ast.comments;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// Doxygen \\tparam command, describes a template parameter.
//<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 805,
 FQN="clang::comments::TParamCommandComment", NM="_ZN5clang8comments20TParamCommandCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20TParamCommandCommentE")
//</editor-fold>
public class TParamCommandComment extends /*public*/ BlockCommandComment {
/*private:*/
  /// If this template parameter name was resolved (found in template parameter
  /// list), then this stores a list of position indexes in all template
  /// parameter lists.
  ///
  /// For example:
  /// \verbatim
  ///     template<typename C, template<typename T> class TT>
  ///     void test(TT<int> aaa);
  /// \endverbatim
  /// For C:  Position = { 0 }
  /// For TT: Position = { 1 }
  /// For T:  Position = { 1, 0 }
  private ArrayRefUInt Position;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::TParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 822,
   FQN="clang::comments::TParamCommandComment::TParamCommandComment", NM="_ZN5clang8comments20TParamCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20TParamCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public TParamCommandComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      CommandMarkerKind CommandMarker) {
    // : BlockCommandComment(TParamCommandCommentKind, LocBegin, LocEnd, CommandID, CommandMarker), Position() 
    //START JInit
    super(CommentKind.TParamCommandCommentKind, new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID, 
        CommandMarker);
    this.Position = new ArrayRefUInt();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 830,
   FQN="clang::comments::TParamCommandComment::classof", NM="_ZN5clang8comments20TParamCommandComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20TParamCommandComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.TParamCommandCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::hasParamName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 834,
   FQN="clang::comments::TParamCommandComment::hasParamName", NM="_ZNK5clang8comments20TParamCommandComment12hasParamNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment12hasParamNameEv")
  //</editor-fold>
  public boolean hasParamName() /*const*/ {
    return $greater_uint(getNumArgs(), 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::getParamName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 331,
   FQN="clang::comments::TParamCommandComment::getParamName", NM="_ZNK5clang8comments20TParamCommandComment12getParamNameEPKNS0_11FullCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment12getParamNameEPKNS0_11FullCommentE")
  //</editor-fold>
  public StringRef getParamName(/*const*/ FullComment /*P*/ FC) /*const*/ {
    assert (isPositionValid());
    /*const*/ TemplateParameterList /*P*/ TPL = FC.getDeclInfo().TemplateParameters;
    for (/*uint*/int i = 0, e = getDepth(); i != e; ++i) {
      if (i == e - 1) {
        return TPL.getParam$Const(getIndex(i)).getName();
      }
      /*const*/ NamedDecl /*P*/ Param = TPL.getParam$Const(getIndex(i));
      {
        /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
        if ((TTP != null)) {
          TPL = TTP.getTemplateParameters();
        }
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::getParamNameAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 840,
   FQN="clang::comments::TParamCommandComment::getParamNameAsWritten", NM="_ZNK5clang8comments20TParamCommandComment21getParamNameAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment21getParamNameAsWrittenEv")
  //</editor-fold>
  public StringRef getParamNameAsWritten() /*const*/ {
    return new StringRef(Args.$at(0).Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::getParamNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 844,
   FQN="clang::comments::TParamCommandComment::getParamNameRange", NM="_ZNK5clang8comments20TParamCommandComment17getParamNameRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment17getParamNameRangeEv")
  //</editor-fold>
  public SourceRange getParamNameRange() /*const*/ {
    return new SourceRange(Args.$at(0).Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::isPositionValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 848,
   FQN="clang::comments::TParamCommandComment::isPositionValid", NM="_ZNK5clang8comments20TParamCommandComment15isPositionValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment15isPositionValidEv")
  //</editor-fold>
  public boolean isPositionValid() /*const*//* __attribute__((pure))*/ {
    return !Position.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 852,
   FQN="clang::comments::TParamCommandComment::getDepth", NM="_ZNK5clang8comments20TParamCommandComment8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment8getDepthEv")
  //</editor-fold>
  public /*uint*/int getDepth() /*const*/ {
    assert (isPositionValid());
    return Position.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 857,
   FQN="clang::comments::TParamCommandComment::getIndex", NM="_ZNK5clang8comments20TParamCommandComment8getIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20TParamCommandComment8getIndexEj")
  //</editor-fold>
  public /*uint*/int getIndex(/*uint*/int Depth) /*const*/ {
    assert (isPositionValid());
    return Position.$at(Depth);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TParamCommandComment::setPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 862,
   FQN="clang::comments::TParamCommandComment::setPosition", NM="_ZN5clang8comments20TParamCommandComment11setPositionEN4llvm8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20TParamCommandComment11setPositionEN4llvm8ArrayRefIjEE")
  //</editor-fold>
  public void setPosition(ArrayRefUInt NewPosition) {
    Position.$assign(NewPosition);
    assert (isPositionValid());
  }

  
  @Override public String toString() {
    return "" + "Position=" + Position // NOI18N
              + super.toString(); // NOI18N
  }
}
