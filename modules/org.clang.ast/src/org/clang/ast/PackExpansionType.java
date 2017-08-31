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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;


/// \brief Represents a pack expansion of types.
///
/// Pack expansions are part of C++11 variadic templates. A pack
/// expansion contains a pattern, which itself contains one or more
/// "unexpanded" parameter packs. When instantiated, a pack expansion
/// produces a series of types, each instantiated from the pattern of
/// the expansion, where the Ith instantiation of the pattern uses the
/// Ith arguments bound to each of the unexpanded parameter packs. The
/// pack expansion is considered to "expand" these unexpanded
/// parameter packs.
///
/// \code
/// template<typename ...Types> struct tuple;
///
/// template<typename ...Types>
/// struct tuple_of_references {
///   typedef tuple<Types&...> type;
/// };
/// \endcode
///
/// Here, the pack expansion \c Types&... is represented via a
/// PackExpansionType whose pattern is Types&.
//<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4641,
 FQN="clang::PackExpansionType", NM="_ZN5clang17PackExpansionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17PackExpansionTypeE")
//</editor-fold>
public class PackExpansionType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  /// \brief The pattern of the pack expansion.
  private QualType Pattern;
  
  /// \brief The number of expansions that this pack expansion will
  /// generate when substituted (+1), or indicates that
  ///
  /// This field will only have a non-zero value when some of the parameter
  /// packs that occur within the pattern have been substituted but others have
  /// not.
  private /*uint*/int NumExpansions;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::PackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4653,
   FQN="clang::PackExpansionType::PackExpansionType", NM="_ZN5clang17PackExpansionTypeC1ENS_8QualTypeES1_N4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17PackExpansionTypeC1ENS_8QualTypeES1_N4llvm8OptionalIjEE")
  //</editor-fold>
  /*friend*//*package*/ PackExpansionType(QualType Pattern, QualType Canon, 
      OptionalUInt NumExpansions) {
    // : Type(PackExpansion, Canon, /*Dependent=*/ Pattern->isDependentType(), /*InstantiationDependent=*/ true, /*VariablyModified=*/ Pattern->isVariablyModifiedType(), /*ContainsUnexpandedParameterPack=*/ false), FoldingSetNode(), Pattern(Pattern), NumExpansions(NumExpansions.operator bool() ? * NumExpansions + 1 : 0) 
    //START JInit
    super(TypeClass.PackExpansion, new QualType(Canon), Pattern.$arrow().isDependentType(), 
        true, 
        Pattern.$arrow().isVariablyModifiedType(), 
        false);
    $Node();
    this.Pattern = new QualType(Pattern);
    this.NumExpansions = NumExpansions.$bool() ? NumExpansions.$star() + 1 : 0;
    //END JInit
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  /// \brief Retrieve the pattern of this pack expansion, which is the
  /// type that will be repeatedly instantiated when instantiating the
  /// pack expansion itself.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::getPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4668,
   FQN="clang::PackExpansionType::getPattern", NM="_ZNK5clang17PackExpansionType10getPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17PackExpansionType10getPatternEv")
  //</editor-fold>
  public QualType getPattern() /*const*/ {
    return new QualType(Pattern);
  }

  
  /// \brief Retrieve the number of expansions that this pack expansion will
  /// generate, if known.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::getNumExpansions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4672,
   FQN="clang::PackExpansionType::getNumExpansions", NM="_ZNK5clang17PackExpansionType16getNumExpansionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17PackExpansionType16getNumExpansionsEv")
  //</editor-fold>
  public OptionalUInt getNumExpansions() /*const*/ {
    if ((NumExpansions != 0)) {
      return new OptionalUInt(JD$T$RR.INSTANCE, NumExpansions - 1);
    }
    
    return new OptionalUInt(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4679,
   FQN="clang::PackExpansionType::isSugared", NM="_ZNK5clang17PackExpansionType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17PackExpansionType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return !Pattern.$arrow().isDependentType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4680,
   FQN="clang::PackExpansionType::desugar", NM="_ZNK5clang17PackExpansionType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17PackExpansionType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return isSugared() ? new QualType(Pattern) : new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4682,
   FQN="clang::PackExpansionType::Profile", NM="_ZN5clang17PackExpansionType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17PackExpansionType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getPattern(), getNumExpansions());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4686,
   FQN="clang::PackExpansionType::Profile", NM="_ZN5clang17PackExpansionType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS1_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17PackExpansionType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS1_8OptionalIjEE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Pattern, 
         OptionalUInt NumExpansions) {
    ID.AddPointer(Pattern.getAsOpaquePtr());
    ID.AddBoolean(NumExpansions.hasValue());
    if (NumExpansions.$bool()) {
      ID.AddInteger_uint(NumExpansions.$star());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4694,
   FQN="clang::PackExpansionType::classof", NM="_ZN5clang17PackExpansionType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17PackExpansionType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.PackExpansion;
  }

  @Override public String toString() {
    return "" + "Pattern=" + Pattern // NOI18N
              + ", NumExpansions=" + NumExpansions // NOI18N
              + super.toString(); // NOI18N
  }
}
