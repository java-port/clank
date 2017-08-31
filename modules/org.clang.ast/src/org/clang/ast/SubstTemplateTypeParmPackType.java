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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents the result of substituting a set of types for a template
/// type parameter pack.
///
/// When a pack expansion in the source code contains multiple parameter packs
/// and those parameter packs correspond to different levels of template
/// parameter lists, this type node is used to represent a template type
/// parameter pack from an outer level, which has already had its argument pack
/// substituted but that still lives within a pack expansion that itself
/// could not be instantiated. When actually performing a substitution into
/// that pack expansion (e.g., when all template parameters have corresponding
/// arguments), this type will be replaced with the \c SubstTemplateTypeParmType
/// at the current pack substitution index.
//<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4038,
 FQN="clang::SubstTemplateTypeParmPackType", NM="_ZN5clang29SubstTemplateTypeParmPackTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang29SubstTemplateTypeParmPackTypeE")
//</editor-fold>
public class SubstTemplateTypeParmPackType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  /// \brief The original type parameter.
  private /*const*/ TemplateTypeParmType /*P*/ Replaced;
  
  /// \brief A pointer to the set of template arguments that this
  /// parameter pack is instantiated with.
  private /*const*/type$ptr<TemplateArgument/*P*/> Arguments;
  
  /// \brief The number of template arguments in \c Arguments.
  private /*uint*/int NumArguments;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::SubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3073,
   FQN="clang::SubstTemplateTypeParmPackType::SubstTemplateTypeParmPackType", NM="_ZN5clang29SubstTemplateTypeParmPackTypeC1EPKNS_20TemplateTypeParmTypeENS_8QualTypeERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang29SubstTemplateTypeParmPackTypeC1EPKNS_20TemplateTypeParmTypeENS_8QualTypeERKNS_16TemplateArgumentE")
  //</editor-fold>
  /*friend*//*package*/ SubstTemplateTypeParmPackType(/*const*/ TemplateTypeParmType /*P*/ Param, 
      QualType Canon, 
      final /*const*/ TemplateArgument /*&*/ ArgPack) {
    // : Type(SubstTemplateTypeParmPack, Canon, true, true, false, true), FoldingSetNode(), Replaced(Param), Arguments(ArgPack.pack_begin()), NumArguments(ArgPack.pack_size()) 
    //START JInit
    super(TypeClass.SubstTemplateTypeParmPack, new QualType(Canon), true, true, false, true);
    $Node();
    this.Replaced = Param;
    this.Arguments = $tryClone(ArgPack.pack_begin());
    this.NumArguments = ArgPack.pack_size();
    //END JInit
  }

  
  /*friend  class ASTContext*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4056,
   FQN="clang::SubstTemplateTypeParmPackType::getIdentifier", NM="_ZNK5clang29SubstTemplateTypeParmPackType13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang29SubstTemplateTypeParmPackType13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Replaced.getIdentifier();
  }

  
  /// Gets the template parameter that was substituted for.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::getReplacedParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4059,
   FQN="clang::SubstTemplateTypeParmPackType::getReplacedParameter", NM="_ZNK5clang29SubstTemplateTypeParmPackType20getReplacedParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang29SubstTemplateTypeParmPackType20getReplacedParameterEv")
  //</editor-fold>
  public /*const*/ TemplateTypeParmType /*P*/ getReplacedParameter() /*const*/ {
    return Replaced;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4063,
   FQN="clang::SubstTemplateTypeParmPackType::isSugared", NM="_ZNK5clang29SubstTemplateTypeParmPackType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang29SubstTemplateTypeParmPackType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4064,
   FQN="clang::SubstTemplateTypeParmPackType::desugar", NM="_ZNK5clang29SubstTemplateTypeParmPackType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang29SubstTemplateTypeParmPackType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::getArgumentPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3083,
   FQN="clang::SubstTemplateTypeParmPackType::getArgumentPack", NM="_ZNK5clang29SubstTemplateTypeParmPackType15getArgumentPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang29SubstTemplateTypeParmPackType15getArgumentPackEv")
  //</editor-fold>
  public TemplateArgument getArgumentPack() /*const*/ {
    return new TemplateArgument(llvm.makeArrayRef(Arguments, NumArguments));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3087,
   FQN="clang::SubstTemplateTypeParmPackType::Profile", NM="_ZN5clang29SubstTemplateTypeParmPackType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang29SubstTemplateTypeParmPackType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getReplacedParameter(), getArgumentPack());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3091,
   FQN="clang::SubstTemplateTypeParmPackType::Profile", NM="_ZN5clang29SubstTemplateTypeParmPackType7ProfileERN4llvm16FoldingSetNodeIDEPKNS_20TemplateTypeParmTypeERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang29SubstTemplateTypeParmPackType7ProfileERN4llvm16FoldingSetNodeIDEPKNS_20TemplateTypeParmTypeERKNS_16TemplateArgumentE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         /*const*/ TemplateTypeParmType /*P*/ Replaced, 
         final /*const*/ TemplateArgument /*&*/ ArgPack) {
    ID.AddPointer(Replaced);
    ID.AddInteger_uint(ArgPack.pack_size());
    for (final /*const*/ TemplateArgument /*&*/ P : ArgPack.pack_elements())  {
      ID.AddPointer(P.getAsType().getAsOpaquePtr());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmPackType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4073,
   FQN="clang::SubstTemplateTypeParmPackType::classof", NM="_ZN5clang29SubstTemplateTypeParmPackType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang29SubstTemplateTypeParmPackType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.SubstTemplateTypeParmPack;
  }

  @Override public String toString() {
    return "" + "Replaced=" + Replaced // NOI18N
              + ", Arguments=" + Arguments // NOI18N
              + ", NumArguments=" + NumArguments // NOI18N
              + super.toString(); // NOI18N
  }
}
