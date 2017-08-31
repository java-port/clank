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
import org.llvm.adt.*;


/// \brief Represents the result of substituting a type for a template
/// type parameter.
///
/// Within an instantiated template, all template type parameters have
/// been replaced with these.  They are used solely to record that a
/// type was originally written as a template type parameter;
/// therefore they are never canonical.
//<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3983,
 FQN="clang::SubstTemplateTypeParmType", NM="_ZN5clang25SubstTemplateTypeParmTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang25SubstTemplateTypeParmTypeE")
//</editor-fold>
public class SubstTemplateTypeParmType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  // The original type parameter.
  private /*const*/ TemplateTypeParmType /*P*/ Replaced;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::SubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3987,
   FQN="clang::SubstTemplateTypeParmType::SubstTemplateTypeParmType", NM="_ZN5clang25SubstTemplateTypeParmTypeC1EPKNS_20TemplateTypeParmTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang25SubstTemplateTypeParmTypeC1EPKNS_20TemplateTypeParmTypeENS_8QualTypeE")
  //</editor-fold>
  /*friend*//*package*/ SubstTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ Param, QualType Canon) {
    // : Type(SubstTemplateTypeParm, Canon, Canon->isDependentType(), Canon->isInstantiationDependentType(), Canon->isVariablyModifiedType(), Canon->containsUnexpandedParameterPack()), FoldingSetNode(), Replaced(Param) 
    //START JInit
    super(TypeClass.SubstTemplateTypeParm, new QualType(Canon), Canon.$arrow().isDependentType(), 
        Canon.$arrow().isInstantiationDependentType(), 
        Canon.$arrow().isVariablyModifiedType(), 
        Canon.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.Replaced = Param;
    //END JInit
  }

  
  /*friend  class ASTContext*/
/*public:*/
  /// Gets the template parameter that was substituted for.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::getReplacedParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3998,
   FQN="clang::SubstTemplateTypeParmType::getReplacedParameter", NM="_ZNK5clang25SubstTemplateTypeParmType20getReplacedParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang25SubstTemplateTypeParmType20getReplacedParameterEv")
  //</editor-fold>
  public /*const*/ TemplateTypeParmType /*P*/ getReplacedParameter() /*const*/ {
    return Replaced;
  }

  
  /// Gets the type that was substituted for the template
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::getReplacementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4004,
   FQN="clang::SubstTemplateTypeParmType::getReplacementType", NM="_ZNK5clang25SubstTemplateTypeParmType18getReplacementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang25SubstTemplateTypeParmType18getReplacementTypeEv")
  //</editor-fold>
  public QualType getReplacementType() /*const*/ {
    return getCanonicalTypeInternal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4008,
   FQN="clang::SubstTemplateTypeParmType::isSugared", NM="_ZNK5clang25SubstTemplateTypeParmType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang25SubstTemplateTypeParmType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4009,
   FQN="clang::SubstTemplateTypeParmType::desugar", NM="_ZNK5clang25SubstTemplateTypeParmType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang25SubstTemplateTypeParmType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getReplacementType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4011,
   FQN="clang::SubstTemplateTypeParmType::Profile", NM="_ZN5clang25SubstTemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang25SubstTemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getReplacedParameter(), getReplacementType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4014,
   FQN="clang::SubstTemplateTypeParmType::Profile", NM="_ZN5clang25SubstTemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDEPKNS_20TemplateTypeParmTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang25SubstTemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDEPKNS_20TemplateTypeParmTypeENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         /*const*/ TemplateTypeParmType /*P*/ Replaced, 
         QualType Replacement) {
    ID.AddPointer(Replaced);
    ID.AddPointer(Replacement.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTypeParmType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4021,
   FQN="clang::SubstTemplateTypeParmType::classof", NM="_ZN5clang25SubstTemplateTypeParmType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang25SubstTemplateTypeParmType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.SubstTemplateTypeParm;
  }

  @Override public String toString() {
    return "" + "Replaced=" + Replaced // NOI18N
              + super.toString(); // NOI18N
  }
}
