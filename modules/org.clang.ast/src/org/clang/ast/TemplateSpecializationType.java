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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.llvm.adt.java.TrailingObjectsUtils;

/// \brief Represents a type template specialization; the template
/// must be a class template, a type alias template, or a template
/// template parameter.  A template which cannot be resolved to one of
/// these, e.g. because it is written with a dependent scope
/// specifier, is instead represented as a
/// @c DependentTemplateSpecializationType.
///
/// A non-dependent template specialization type is always "sugar",
/// typically for a \c RecordType.  For example, a class template
/// specialization type of \c vector<int> will refer to a tag type for
/// the instantiation \c std::vector<int, std::allocator<int>>
///
/// Template specializations are dependent if either the template or
/// any of the template arguments are dependent, in which case the
/// type may also be canonical.
///
/// Instances of this type are allocated with a trailing array of
/// TemplateArguments, followed by a QualType representing the
/// non-canonical aliased type when the template is a type alias
/// template.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4154,
 FQN="clang::TemplateSpecializationType", NM="_ZN5clang26TemplateSpecializationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationTypeE")
//</editor-fold>
public class TemplateSpecializationType extends /*public*/ Type implements /*public*/ FoldingSetImpl.ContextualNode<ASTContext>, Iterable<TemplateArgument> {
  /// The name of the template being specialized.  This is
  /// either a TemplateName::Template (in which case it is a
  /// ClassTemplateDecl*, a TemplateTemplateParmDecl*, or a
  /// TypeAliasTemplateDecl*), a
  /// TemplateName::SubstTemplateTemplateParmPack, or a
  /// TemplateName::SubstTemplateTemplateParm (in which case the
  /// replacement must, recursively, be one of these).
  private TemplateName Template;
  
  /// The number of template arguments named in this class template
  /// specialization.
  private /*uint*/int NumArgs /*: 31*/;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  type$ptr<?/*P*/> TemplateArgs;
  
  /// Whether this template specialization type is a substituted type alias.
  private /*JBIT unsigned int*/ boolean TypeAlias /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::TemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3122,
   FQN="clang::TemplateSpecializationType::TemplateSpecializationType", NM="_ZN5clang26TemplateSpecializationTypeC1ENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationTypeC1ENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeES6_")
  //</editor-fold>
  /*friend*//*package*/ TemplateSpecializationType(type$ptr<?> $this, TemplateName T, 
      ArrayRef<TemplateArgument> Args, 
      QualType Canon, QualType AliasedType) {
    // : Type(TemplateSpecialization, Canon.isNull() ? QualType(this, 0) : Canon, Canon.isNull() ? true : Canon->isDependentType(), Canon.isNull() ? true : Canon->isInstantiationDependentType(), false, T.containsUnexpandedParameterPack()), FoldingSetNode(), Template(T), NumArgs(Args.size()), TypeAlias(!AliasedType.isNull()) 
    //START JInit
    $Type(TypeClass.TemplateSpecialization, 
        Canon.isNull() ? new QualType(this, 0) : new QualType(Canon), 
        Canon.isNull() ? true : Canon.$arrow().isDependentType(), 
        Canon.isNull() ? true : Canon.$arrow().isInstantiationDependentType(), 
        false, 
        T.containsUnexpandedParameterPack());
    $Node();
    this.Template = new TemplateName(T);
    this.NumArgs = Args.size();
    this.TypeAlias = !AliasedType.isNull();
    //END JInit
    assert (!(T.getAsDependentTemplateName() != null)) : "Use DependentTemplateSpecializationType for dependent template-name";
    assert ((T.getKind() == TemplateName.NameKind.Template || T.getKind() == TemplateName.NameKind.SubstTemplateTemplateParm || T.getKind() == TemplateName.NameKind.SubstTemplateTemplateParmPack)) : "Unexpected template name for TemplateSpecializationType";
    
    this.TemplateArgs = TrailingObjectsUtils.$putThisAndShift(this, $this);//$tryClone(((type$ptr<TemplateArgument/*P*/> )reinterpret_cast(type$ptr.class, this + 1)));
    type$ptr<TemplateArgument/*P*/> _TemplateArgs = (type$ptr) $tryClone(TemplateArgs);
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args) {
      // Update instantiation-dependent and variably-modified bits.
      // If the canonical type exists and is non-dependent, the template
      // specialization type can be non-dependent even if one of the type
      // arguments is. Given:
      //   template<typename T> using U = int;
      // U<T> is always non-dependent, irrespective of the type T.
      // However, U<Ts> contains an unexpanded parameter pack, even though
      // its expansion (and thus its desugared type) doesn't.
      if (Arg.isInstantiationDependent()) {
        setInstantiationDependent();
      }
      if (Arg.getKind() == TemplateArgument.ArgKind.Type
         && Arg.getAsType().$arrow().isVariablyModifiedType()) {
        setVariablyModified();
      }
      if (Arg.containsUnexpandedParameterPack()) {
        setContainsUnexpandedParameterPack();
      }
      ///*FIXME:NEW_EXPR[System]*/TemplateArgs.$postInc() = /*new (TemplateArgs++)*/ new TemplateArgument(Arg);
      _TemplateArgs.$set(new TemplateArgument(Arg));_TemplateArgs.$postInc();
    }
    
    // Store the aliased type if this is a type alias template specialization.
    if (TypeAlias) {
      type$ptr<?/*P*/> Begin = $tryClone(TemplateArgs);
      ((type$ptr<QualType /*P*/> )reinterpret_cast(type$ptr.class, Begin.$add(getNumArgs()))).$set(AliasedType);
    }
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  /// Determine whether any of the given template arguments are dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::anyDependentTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3107,
   FQN="clang::TemplateSpecializationType::anyDependentTemplateArguments", NM="_ZN5clang26TemplateSpecializationType29anyDependentTemplateArgumentsEN4llvm8ArrayRefINS_19TemplateArgumentLocEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationType29anyDependentTemplateArgumentsEN4llvm8ArrayRefINS_19TemplateArgumentLocEEERb")
  //</editor-fold>
  public static boolean anyDependentTemplateArguments(ArrayRef<TemplateArgumentLoc> Args, 
                               final bool$ref/*bool &*/ InstantiationDependent) {
    for (final /*const*/ TemplateArgumentLoc /*&*/ ArgLoc : Args) {
      if (ArgLoc.getArgument().isDependent()) {
        InstantiationDependent.$set(true);
        return true;
      }
      if (ArgLoc.getArgument().isInstantiationDependent()) {
        InstantiationDependent.$set(true);
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::anyDependentTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3100,
   FQN="clang::TemplateSpecializationType::anyDependentTemplateArguments", NM="_ZN5clang26TemplateSpecializationType29anyDependentTemplateArgumentsERKNS_24TemplateArgumentListInfoERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationType29anyDependentTemplateArgumentsERKNS_24TemplateArgumentListInfoERb")
  //</editor-fold>
  public static boolean anyDependentTemplateArguments(final /*const*/ TemplateArgumentListInfo /*&*/ Args, 
                               final bool$ref/*bool &*/ InstantiationDependent) {
    return anyDependentTemplateArguments(Args.arguments(), 
        InstantiationDependent);
  }

  
  /// \brief Print a template argument list, including the '<' and '>'
  /// enclosing the template arguments.
  
  /// \brief Print a template argument list, including the '<' and '>'
  /// enclosing the template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::PrintTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1442,
   FQN="clang::TemplateSpecializationType::PrintTemplateArgumentList", NM="_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamENS1_8ArrayRefINS_16TemplateArgumentEEERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamENS1_8ArrayRefINS_16TemplateArgumentEEERKNS_14PrintingPolicyEb")
  //</editor-fold>
  public static void PrintTemplateArgumentList1(final raw_ostream /*&*/ OS, ArrayRef<TemplateArgument> Args, 
                            final /*const*/ PrintingPolicy /*&*/ Policy) {
    PrintTemplateArgumentList1(OS, Args, 
                            Policy, false);
  }
  public static void PrintTemplateArgumentList1(final raw_ostream /*&*/ OS, ArrayRef<TemplateArgument> Args, 
                            final /*const*/ PrintingPolicy /*&*/ Policy, boolean SkipBrackets/*= false*/) {
    /*const*/char$ptr/*char P*/ Comma = $tryClone(Policy.MSVCFormatting ? $COMMA : $COMMA_SPACE);
    if (!SkipBrackets) {
      OS.$out_char($$LT);
    }
    
    boolean needSpace = false;
    boolean FirstArg = true;
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args) {
      raw_svector_ostream ArgOS = null;
      try {
        // Print the argument into a string.
        SmallString/*128*/ Buf/*J*/= new SmallString/*128*/(128);
        ArgOS/*J*/= new raw_svector_ostream(Buf);
        if (Arg.getKind() == TemplateArgument.ArgKind.Pack) {
          if ((Arg.pack_size() != 0) && !FirstArg) {
            OS.$out(Comma);
          }
          PrintTemplateArgumentList1(ArgOS, 
              Arg.getPackAsArray(), 
              Policy, true);
        } else {
          if (!FirstArg) {
            OS.$out(Comma);
          }
          Arg.print(Policy, ArgOS);
        }
        StringRef ArgString = ArgOS.str();
        
        // If this is the first argument and its string representation
        // begins with the global scope specifier ('::foo'), add a space
        // to avoid printing the diagraph '<:'.
        if (FirstArg && !ArgString.empty() && ArgString.$at(0) == $$COLON) {
          OS.$out_char($$SPACE);
        }
        
        OS.$out(/*NO_COPY*/ArgString);
        
        needSpace = (!ArgString.empty() && ArgString.back() == $$GT);
        FirstArg = false;
      } finally {
        if (ArgOS != null) { ArgOS.$destroy(); }
      }
    }
    
    // If the last character of our string is '>', add another space to
    // keep the two '>''s separate tokens. We don't *have* to do this in
    // C++0x, but it's still good hygiene.
    if (needSpace) {
      OS.$out_char($$SPACE);
    }
    if (!SkipBrackets) {
      OS.$out_char($$GT);
    }
  }


  
  // Sadly, repeat all that with TemplateArgLoc.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::PrintTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1491,
   FQN="clang::TemplateSpecializationType::PrintTemplateArgumentList", NM="_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamENS1_8ArrayRefINS_19TemplateArgumentLocEEERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamENS1_8ArrayRefINS_19TemplateArgumentLocEEERKNS_14PrintingPolicyE")
  //</editor-fold>
  public static void PrintTemplateArgumentList2(final raw_ostream /*&*/ OS, 
                            ArrayRef<TemplateArgumentLoc> Args, 
                            final /*const*/ PrintingPolicy /*&*/ Policy) {
    OS.$out_char($$LT);
    /*const*/char$ptr/*char P*/ Comma = $tryClone(Policy.MSVCFormatting ? $COMMA : $COMMA_SPACE);
    
    boolean needSpace = false;
    boolean FirstArg = true;
    for (final /*const*/ TemplateArgumentLoc /*&*/ Arg : Args) {
      raw_svector_ostream ArgOS = null;
      try {
        if (!FirstArg) {
          OS.$out(Comma);
        }
        
        // Print the argument into a string.
        SmallString/*128*/ Buf/*J*/= new SmallString/*128*/(128);
        ArgOS/*J*/= new raw_svector_ostream(Buf);
        if (Arg.getArgument().getKind() == TemplateArgument.ArgKind.Pack) {
          PrintTemplateArgumentList1(ArgOS, 
              Arg.getArgument().getPackAsArray(), 
              Policy, true);
        } else {
          Arg.getArgument().print(Policy, ArgOS);
        }
        StringRef ArgString = ArgOS.str();
        
        // If this is the first argument and its string representation
        // begins with the global scope specifier ('::foo'), add a space
        // to avoid printing the diagraph '<:'.
        if (FirstArg && !ArgString.empty() && ArgString.$at(0) == $$COLON) {
          OS.$out_char($$SPACE);
        }
        
        OS.$out(/*NO_COPY*/ArgString);
        
        needSpace = (!ArgString.empty() && ArgString.back() == $$GT);
        FirstArg = false;
      } finally {
        if (ArgOS != null) { ArgOS.$destroy(); }
      }
    }
    
    // If the last character of our string is '>', add another space to
    // keep the two '>''s separate tokens. We don't *have* to do this in
    // C++0x, but it's still good hygiene.
    if (needSpace) {
      OS.$out_char($$SPACE);
    }
    
    OS.$out_char($$GT);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::PrintTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1433,
   FQN="clang::TemplateSpecializationType::PrintTemplateArgumentList", NM="_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamERKNS_24TemplateArgumentListInfoERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang26TemplateSpecializationType25PrintTemplateArgumentListERN4llvm11raw_ostreamERKNS_24TemplateArgumentListInfoERKNS_14PrintingPolicyE")
  //</editor-fold>
  public static void PrintTemplateArgumentList(final raw_ostream /*&*/ OS, 
                           final /*const*/ TemplateArgumentListInfo /*&*/ Args, 
                           final /*const*/ PrintingPolicy /*&*/ Policy) {
    PrintTemplateArgumentList2(OS, 
        Args.arguments(), 
        Policy);
    /*JAVA:return*/return;
  }


  
  /// True if this template specialization type matches a current
  /// instantiation in the context in which it is found.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::isCurrentInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4205,
   FQN="clang::TemplateSpecializationType::isCurrentInstantiation", NM="_ZNK5clang26TemplateSpecializationType22isCurrentInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType22isCurrentInstantiationEv")
  //</editor-fold>
  public boolean isCurrentInstantiation() /*const*/ {
    return isa_InjectedClassNameType(getCanonicalTypeInternal());
  }

  
  /// \brief Determine if this template specialization type is for a type alias
  /// template that has been substituted.
  ///
  /// Nearly every template specialization type whose template is an alias
  /// template will be substituted. However, this is not the case when
  /// the specialization contains a pack expansion but the template alias
  /// does not have a corresponding parameter pack, e.g.,
  ///
  /// \code
  /// template<typename T, typename U, typename V> struct S;
  /// template<typename T, typename U> using A = S<T, int, U>;
  /// template<typename... Ts> struct X {
  ///   typedef A<Ts...> type; // not a type alias
  /// };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::isTypeAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4224,
   FQN="clang::TemplateSpecializationType::isTypeAlias", NM="_ZNK5clang26TemplateSpecializationType11isTypeAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType11isTypeAliasEv")
  //</editor-fold>
  public boolean isTypeAlias() /*const*/ {
    return TypeAlias;
  }

  
  /// Get the aliased type, if this is a specialization of a type alias
  /// template.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::getAliasedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4228,
   FQN="clang::TemplateSpecializationType::getAliasedType", NM="_ZNK5clang26TemplateSpecializationType14getAliasedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType14getAliasedTypeEv")
  //</editor-fold>
  public QualType getAliasedType() /*const*/ {
    assert (isTypeAlias()) : "not a type alias template specialization";
    return new QualType(((/*const*/type$ptr<QualType /*P*/> )reinterpret_cast(/*const*/type$ptr.class, end())).$star());
  }

  
  /*typedef const TemplateArgument *iterator*/
//  public final class iterator extends /*const*/type$ptr<TemplateArgument/*P*/> { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4235,
   FQN="clang::TemplateSpecializationType::begin", NM="_ZNK5clang26TemplateSpecializationType5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType5beginEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgument/*P*/> begin() /*const*/ {
    return getArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 643,
   FQN="clang::TemplateSpecializationType::end", NM="_ZNK5clang26TemplateSpecializationType3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType3endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<TemplateArgument/*P*/>/*iterator*/ end() /*const*/ {
    return getArgs().$add(getNumArgs());
  }
 // defined inline in TemplateBase.h
  
  /// Retrieve the name of the template that we are specializing.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::getTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4239,
   FQN="clang::TemplateSpecializationType::getTemplateName", NM="_ZNK5clang26TemplateSpecializationType15getTemplateNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType15getTemplateNameEv")
  //</editor-fold>
  public TemplateName getTemplateName() /*const*/ {
    return new TemplateName(Template);
  }

  
  /// Retrieve the template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::getArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4242,
   FQN="clang::TemplateSpecializationType::getArgs", NM="_ZNK5clang26TemplateSpecializationType7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType7getArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgument/*P*/> getArgs() /*const*/ {
    return (type$ptr<TemplateArgument/*P*/> )reinterpret_cast(/*const*/type$ptr.class, TemplateArgs);
  }

  
  /// Retrieve the number of template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4247,
   FQN="clang::TemplateSpecializationType::getNumArgs", NM="_ZNK5clang26TemplateSpecializationType10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  /// Retrieve a specific template argument as a type.
  /// \pre \c isArgType(Arg)
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 653,
   FQN="clang::TemplateSpecializationType::getArg", NM="_ZNK5clang26TemplateSpecializationType6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType6getArgEj")
  //</editor-fold>
  public /*inline*/ /*const*/ TemplateArgument /*&*/ getArg(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, getNumArgs())) : "Template argument out of range";
    return getArgs().$at(Idx);
  }
 // in TemplateBase.h
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4253,
   FQN="clang::TemplateSpecializationType::template_arguments", NM="_ZNK5clang26TemplateSpecializationType18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgument>(getArgs(), NumArgs, false)/* }*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4257,
   FQN="clang::TemplateSpecializationType::isSugared", NM="_ZNK5clang26TemplateSpecializationType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return !isDependentType() || isCurrentInstantiation() || isTypeAlias();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4260,
   FQN="clang::TemplateSpecializationType::desugar", NM="_ZNK5clang26TemplateSpecializationType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang26TemplateSpecializationType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getCanonicalTypeInternal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4262,
   FQN="clang::TemplateSpecializationType::Profile", NM="_ZN5clang26TemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ASTContext /*&*/ Ctx) {
    Profile(ID, /*NO_COPY*/Template, template_arguments(), Ctx);
    if (isTypeAlias()) {
      getAliasedType().Profile(ID);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3168,
   FQN="clang::TemplateSpecializationType::Profile", NM="_ZN5clang26TemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDENS_12TemplateNameENS1_8ArrayRefINS_16TemplateArgumentEEERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationType7ProfileERN4llvm16FoldingSetNodeIDENS_12TemplateNameENS1_8ArrayRefINS_16TemplateArgumentEEERKNS_10ASTContextE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         TemplateName T, 
         ArrayRef<TemplateArgument> Args, 
         final /*const*/ ASTContext /*&*/ Context) {
    T.Profile(ID);
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args)  {
      Arg.Profile(ID, Context);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4272,
   FQN="clang::TemplateSpecializationType::classof", NM="_ZN5clang26TemplateSpecializationType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang26TemplateSpecializationType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.TemplateSpecialization;
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<TemplateArgument> iterator() {return new JavaIterator<>(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Template=" + Template // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + ", TypeAlias=" + TypeAlias // NOI18N
              + super.toString(); // NOI18N
  }
}
