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

import java.util.Iterator;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// Represents a template specialization type whose template cannot be
/// resolved, e.g.
///   A<T>::template B<T>
//<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4549,
 FQN="clang::DependentTemplateSpecializationType", NM="_ZN5clang35DependentTemplateSpecializationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationTypeE")
//</editor-fold>
public class DependentTemplateSpecializationType extends /*public*/ TypeWithKeyword implements /*public*/ FoldingSetImpl.ContextualNode<ASTContext>, Iterable<TemplateArgument> {
  
  /// The nested name specifier containing the qualifier.
  private NestedNameSpecifier /*P*/ NNS;
  
  /// The identifier of the template.
  private /*const*/ IdentifierInfo /*P*/ Name;
  
  /// \brief The number of template arguments named in this class template
  /// specialization.
  private /*uint*/int NumArgs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getArgBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4563,
   FQN="clang::DependentTemplateSpecializationType::getArgBuffer", NM="_ZNK5clang35DependentTemplateSpecializationType12getArgBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType12getArgBufferEv")
  //</editor-fold>
  private /*const*/type$ptr<TemplateArgument/*P*/> getArgBuffer$Const() /*const*/ {
    return TemplateArguments;//((/*const*/type$ptr<TemplateArgument/*P*/> )reinterpret_cast(/*const*/type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getArgBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4566,
   FQN="clang::DependentTemplateSpecializationType::getArgBuffer", NM="_ZN5clang35DependentTemplateSpecializationType12getArgBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationType12getArgBufferEv")
  //</editor-fold>
  private type$ptr<TemplateArgument/*P*/> getArgBuffer() {
    return TemplateArguments;//((type$ptr<TemplateArgument/*P*/> )reinterpret_cast(type$ptr.class, this + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::DependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2460,
   FQN="clang::DependentTemplateSpecializationType::DependentTemplateSpecializationType", NM="_ZN5clang35DependentTemplateSpecializationTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeE")
  //</editor-fold>
  /*friend*//*package*/ DependentTemplateSpecializationType(ElaboratedTypeKeyword Keyword, 
      NestedNameSpecifier /*P*/ NNS, /*const*/ IdentifierInfo /*P*/ Name, 
      ArrayRef<TemplateArgument> Args, 
      QualType Canon) {
    // : TypeWithKeyword(Keyword, DependentTemplateSpecialization, Canon, true, true, /*VariablyModified=*/ false, NNS && NNS->containsUnexpandedParameterPack()), FoldingSetNode(), NNS(NNS), Name(Name), NumArgs(Args.size()) 
    //START JInit
    super(Keyword, TypeClass.DependentTemplateSpecialization, new QualType(Canon), true, true, 
        false, 
        (NNS != null) && NNS.containsUnexpandedParameterPack());
    $Node();
    this.NNS = NNS;
    this.Name = Name;
    this.NumArgs = Args.size();
    //END JInit
    assert ((!(NNS != null) || NNS.isDependent())) : "DependentTemplateSpecializatonType requires dependent qualifier";
    TemplateArguments = create_type$ptr(new TemplateArgument[NumArgs]);
    type$ptr<TemplateArgument/*P*/> ArgBuffer = $tryClone(TemplateArguments);
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args) {
      if (Arg.containsUnexpandedParameterPack()) {
        setContainsUnexpandedParameterPack();
      }
      ///*FIXME:NEW_EXPR[System]*/ArgBuffer.$postInc() = /*new (ArgBuffer++)*/ new TemplateArgument(Arg);
      ArgBuffer.$set(new TemplateArgument(Arg)); ArgBuffer.$postInc();
    }
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4579,
   FQN="clang::DependentTemplateSpecializationType::getQualifier", NM="_ZNK5clang35DependentTemplateSpecializationType12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return NNS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4580,
   FQN="clang::DependentTemplateSpecializationType::getIdentifier", NM="_ZNK5clang35DependentTemplateSpecializationType13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType13getIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Name;
  }

  
  /// \brief Retrieve the template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4583,
   FQN="clang::DependentTemplateSpecializationType::getArgs", NM="_ZNK5clang35DependentTemplateSpecializationType7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType7getArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgument/*P*/> getArgs() /*const*/ {
    return getArgBuffer$Const();
  }

  
  /// \brief Retrieve the number of template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4588,
   FQN="clang::DependentTemplateSpecializationType::getNumArgs", NM="_ZNK5clang35DependentTemplateSpecializationType10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 659,
   FQN="clang::DependentTemplateSpecializationType::getArg", NM="_ZNK5clang35DependentTemplateSpecializationType6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType6getArgEj")
  //</editor-fold>
  public /*inline*/ /*const*/ TemplateArgument /*&*/ getArg(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, getNumArgs())) : "Template argument out of range";
    return getArgs().$at(Idx);
  }
 // in TemplateBase.h
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4592,
   FQN="clang::DependentTemplateSpecializationType::template_arguments", NM="_ZNK5clang35DependentTemplateSpecializationType18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgument>(getArgs(), NumArgs, false)/* }*/;
  }

  
  /*typedef const TemplateArgument *iterator*/
//  public final class iterator extends /*const*/type$ptr<TemplateArgument/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4597,
   FQN="clang::DependentTemplateSpecializationType::begin", NM="_ZNK5clang35DependentTemplateSpecializationType5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType5beginEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgument/*P*/> begin() /*const*/ {
    return getArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 648,
   FQN="clang::DependentTemplateSpecializationType::end", NM="_ZNK5clang35DependentTemplateSpecializationType3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType3endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<TemplateArgument> end() /*const*/ {
    return getArgs().$add(getNumArgs());
  }
 // inline in TemplateBase.h
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4600,
   FQN="clang::DependentTemplateSpecializationType::isSugared", NM="_ZNK5clang35DependentTemplateSpecializationType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4601,
   FQN="clang::DependentTemplateSpecializationType::desugar", NM="_ZNK5clang35DependentTemplateSpecializationType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang35DependentTemplateSpecializationType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4603,
   FQN="clang::DependentTemplateSpecializationType::Profile", NM="_ZN5clang35DependentTemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ASTContext /*&*/ Context) {
    Profile(ID, Context, getKeyword(), NNS, Name, /*{ */new ArrayRef<TemplateArgument>(getArgs(), NumArgs, false)/* }*/);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2480,
   FQN="clang::DependentTemplateSpecializationType::Profile", NM="_ZN5clang35DependentTemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS1_8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS1_8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ ASTContext /*&*/ Context, 
         ElaboratedTypeKeyword Keyword, 
         NestedNameSpecifier /*P*/ Qualifier, 
         /*const*/ IdentifierInfo /*P*/ Name, 
         ArrayRef<TemplateArgument> Args) {
    ID.AddInteger_int(Keyword.getValue());
    ID.AddPointer(Qualifier);
    ID.AddPointer(Name);
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args)  {
      Arg.Profile(ID, Context);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4614,
   FQN="clang::DependentTemplateSpecializationType::classof", NM="_ZN5clang35DependentTemplateSpecializationType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang35DependentTemplateSpecializationType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.DependentTemplateSpecialization;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<TemplateArgument/*P*/> TemplateArguments;

  @Override
  public Iterator<TemplateArgument> iterator() {
    return new JavaIterator<TemplateArgument>(begin(), end());
  }
// EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NNS=" + NNS // NOI18N
              + ", Name=" + Name // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
