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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


/// \brief Represents a C++11 auto or C++14 decltype(auto) type.
///
/// These types are usually a placeholder for a deduced type. However, before
/// the initializer is attached, or if the initializer is type-dependent, there
/// is no deduced type and an auto type is canonical. In the latter case, it is
/// also a dependent type.
//<editor-fold defaultstate="collapsed" desc="clang::AutoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4084,
 FQN="clang::AutoType", NM="_ZN5clang8AutoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8AutoTypeE")
//</editor-fold>
public class AutoType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::AutoType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call $Type, not super due to use of 'this'*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4085,
   FQN="clang::AutoType::AutoType", NM="_ZN5clang8AutoTypeC1ENS_8QualTypeENS_15AutoTypeKeywordEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8AutoTypeC1ENS_8QualTypeENS_15AutoTypeKeywordEb")
  //</editor-fold>
  /*friend*//*package*/ AutoType(QualType DeducedType, AutoTypeKeyword Keyword, boolean IsDependent) {
    // : Type(Auto, DeducedType.isNull() ? QualType(this, 0) : DeducedType, /*Dependent=*/ IsDependent, /*InstantiationDependent=*/ IsDependent, /*VariablyModified=*/ false, /*ContainsParameterPack=*/ DeducedType.isNull() ? false : DeducedType->containsUnexpandedParameterPack()), FoldingSetNode() 
    //START JInit
    $Type(TypeClass.Auto, DeducedType.isNull() ? new QualType(this, 0) : new QualType(DeducedType), 
        IsDependent, IsDependent, 
        false, 
        DeducedType.isNull() ? false : DeducedType.$arrow().containsUnexpandedParameterPack());
    $Node();
    //END JInit
    assert ((DeducedType.isNull() || !IsDependent)) : "auto deduced to dependent type";
    Unnamed_field.AutoTypeBits.Keyword = $uint2uint_2bits(((/*uint*/int)Keyword.getValue()));
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::isDecltypeAuto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4099,
   FQN="clang::AutoType::isDecltypeAuto", NM="_ZNK5clang8AutoType14isDecltypeAutoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType14isDecltypeAutoEv")
  //</editor-fold>
  public boolean isDecltypeAuto() /*const*/ {
    return getKeyword() == AutoTypeKeyword.DecltypeAuto;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::getKeyword">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*convert to uint*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4102,
   FQN="clang::AutoType::getKeyword", NM="_ZNK5clang8AutoType10getKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType10getKeywordEv")
  //</editor-fold>
  public AutoTypeKeyword getKeyword() /*const*/ {
    return AutoTypeKeyword.valueOf($uchar2uint(Unnamed_field.AutoTypeBits.Keyword));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4106,
   FQN="clang::AutoType::isSugared", NM="_ZNK5clang8AutoType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return !isCanonicalUnqualified();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4107,
   FQN="clang::AutoType::desugar", NM="_ZNK5clang8AutoType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getCanonicalTypeInternal();
  }

  
  /// \brief Get the type deduced for this auto type, or null if it's either
  /// not been deduced or was deduced to a dependent type.
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::getDeducedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4111,
   FQN="clang::AutoType::getDeducedType", NM="_ZNK5clang8AutoType14getDeducedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType14getDeducedTypeEv")
  //</editor-fold>
  public QualType getDeducedType() /*const*/ {
    return !isCanonicalUnqualified() ? getCanonicalTypeInternal() : new QualType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::isDeduced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4114,
   FQN="clang::AutoType::isDeduced", NM="_ZNK5clang8AutoType9isDeducedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8AutoType9isDeducedEv")
  //</editor-fold>
  public boolean isDeduced() /*const*/ {
    return !isCanonicalUnqualified() || isDependentType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4118,
   FQN="clang::AutoType::Profile", NM="_ZN5clang8AutoType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8AutoType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getDeducedType(), getKeyword(), isDependentType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4122,
   FQN="clang::AutoType::Profile", NM="_ZN5clang8AutoType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS_15AutoTypeKeywordEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8AutoType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS_15AutoTypeKeywordEb")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Deduced, 
         AutoTypeKeyword Keyword, boolean IsDependent) {
    ID.AddPointer(Deduced.getAsOpaquePtr());
    ID.AddInteger_uint(((/*uint*/int)Keyword.getValue()));
    ID.AddBoolean(IsDependent);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AutoType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4129,
   FQN="clang::AutoType::classof", NM="_ZN5clang8AutoType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8AutoType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Auto;
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
