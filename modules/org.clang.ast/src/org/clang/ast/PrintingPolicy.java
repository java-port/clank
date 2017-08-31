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
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// \brief Describes how types, statements, expressions, and
/// declarations should be printed.
///
/// This type is intended to be small and suitable for passing by value.
/// It is very frequently copied.
//<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 38,
 FQN="clang::PrintingPolicy", NM="_ZN5clang14PrintingPolicyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicyE")
//</editor-fold>
public class/*struct*/ PrintingPolicy {
  /// \brief Create a default printing policy for the specified language.
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy::PrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 40,
   FQN="clang::PrintingPolicy::PrintingPolicy", NM="_ZN5clang14PrintingPolicyC1ERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicyC1ERKNS_11LangOptionsE")
  //</editor-fold>
  public PrintingPolicy(final /*const*/ LangOptions /*&*/ LO) {
    // : Indentation(2), SuppressSpecifiers(false), SuppressTagKeyword(LO.CPlusPlus), IncludeTagDefinition(false), SuppressScope(false), SuppressUnwrittenScope(false), SuppressInitializers(false), ConstantArraySizeAsWritten(false), AnonymousTagLocations(true), SuppressStrongLifetime(false), SuppressLifetimeQualifiers(false), SuppressTemplateArgsInCXXConstructors(false), Bool(LO.Bool), Restrict(LO.C99), Alignof(LO.CPlusPlus11), UnderscoreAlignof(LO.C11), UseVoidForZeroParams(!LO.CPlusPlus), TerseOutput(false), PolishForDeclaration(false), Half(LO.Half), MSWChar(LO.MicrosoftExt && !LO.WChar), IncludeNewlines(true), MSVCFormatting(false) 
    //START JInit
    this.Indentation = $uint2uint_8bits(2);
    this.SuppressSpecifiers = false;
    this.SuppressTagKeyword = LO.CPlusPlus;
    this.IncludeTagDefinition = false;
    this.SuppressScope = false;
    this.SuppressUnwrittenScope = false;
    this.SuppressInitializers = false;
    this.ConstantArraySizeAsWritten = false;
    this.AnonymousTagLocations = true;
    this.SuppressStrongLifetime = false;
    this.SuppressLifetimeQualifiers = false;
    this.SuppressTemplateArgsInCXXConstructors = false;
    this.Bool = LO.Bool;
    this.Restrict = LO.C99;
    this.Alignof = LO.CPlusPlus11;
    this.UnderscoreAlignof = LO.C11;
    this.UseVoidForZeroParams = !LO.CPlusPlus;
    this.TerseOutput = false;
    this.PolishForDeclaration = false;
    this.Half = LO.Half;
    this.MSWChar = LO.MicrosoftExt && !LO.WChar;
    this.IncludeNewlines = true;
    this.MSVCFormatting = false;
    //END JInit
  }

  
  /// \brief Adjust this printing policy for cases where it's known that
  /// we're printing C++ code (for instance, if AST dumping reaches a
  /// C++-only construct). This should not be used if a real LangOptions
  /// object is available.
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy::adjustForCPlusPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 59,
   FQN="clang::PrintingPolicy::adjustForCPlusPlus", NM="_ZN5clang14PrintingPolicy18adjustForCPlusPlusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicy18adjustForCPlusPlusEv")
  //</editor-fold>
  public void adjustForCPlusPlus() {
    SuppressTagKeyword = true;
    Bool = true;
    UseVoidForZeroParams = false;
  }

  
  /// \brief The number of spaces to use to indent each line.
  public /*JBYTE unsigned int*/ byte Indentation /*: 8*/;
  
  /// \brief Whether we should suppress printing of the actual specifiers for
  /// the given type or declaration.
  ///
  /// This flag is only used when we are printing declarators beyond
  /// the first declarator within a declaration group. For example, given:
  ///
  /// \code
  /// const int *x, *y;
  /// \endcode
  ///
  /// SuppressSpecifiers will be false when printing the
  /// declaration for "x", so that we will print "int *x"; it will be
  /// \c true when we print "y", so that we suppress printing the
  /// "const int" type specifier and instead only print the "*y".
  public /*JBIT bool*/ boolean SuppressSpecifiers /*: 1*/;
  
  /// \brief Whether type printing should skip printing the tag keyword.
  ///
  /// This is used when printing the inner type of elaborated types,
  /// (as the tag keyword is part of the elaborated type):
  ///
  /// \code
  /// struct Geometry::Point;
  /// \endcode
  public /*JBIT bool*/ boolean SuppressTagKeyword /*: 1*/;
  
  /// \brief When true, include the body of a tag definition.
  ///
  /// This is used to place the definition of a struct
  /// in the middle of another declaration as with:
  ///
  /// \code
  /// typedef struct { int x, y; } Point;
  /// \endcode
  public /*JBIT bool*/ boolean IncludeTagDefinition /*: 1*/;
  
  /// \brief Suppresses printing of scope specifiers.
  public /*JBIT bool*/ boolean SuppressScope /*: 1*/;
  
  /// \brief Suppress printing parts of scope specifiers that don't need
  /// to be written, e.g., for inline or anonymous namespaces.
  public /*JBIT bool*/ boolean SuppressUnwrittenScope /*: 1*/;
  
  /// \brief Suppress printing of variable initializers.
  ///
  /// This flag is used when printing the loop variable in a for-range
  /// statement. For example, given:
  ///
  /// \code
  /// for (auto x : coll)
  /// \endcode
  ///
  /// SuppressInitializers will be true when printing "auto x", so that the
  /// internal initializer constructed for x will not be printed.
  public /*JBIT bool*/ boolean SuppressInitializers /*: 1*/;
  
  /// \brief Whether we should print the sizes of constant array expressions
  /// as written in the sources.
  ///
  /// This flag determines whether array types declared as
  ///
  /// \code
  /// int a[4+10*10];
  /// char a[] = "A string";
  /// \endcode
  ///
  /// will be printed as written or as follows:
  ///
  /// \code
  /// int a[104];
  /// char a[9] = "A string";
  /// \endcode
  public /*JBIT bool*/ boolean ConstantArraySizeAsWritten /*: 1*/;
  
  /// \brief When printing an anonymous tag name, also print the location of
  /// that entity (e.g., "enum <anonymous at t.h:10:5>"). Otherwise, just 
  /// prints "(anonymous)" for the name.
  public /*JBIT bool*/ boolean AnonymousTagLocations /*: 1*/;
  
  /// \brief When true, suppress printing of the __strong lifetime qualifier in
  /// ARC.
  public /*JBIT unsigned int*/ boolean SuppressStrongLifetime /*: 1*/;
  
  /// \brief When true, suppress printing of lifetime qualifier in
  /// ARC.
  public /*JBIT unsigned int*/ boolean SuppressLifetimeQualifiers /*: 1*/;
  
  /// When true, suppresses printing template arguments in names of C++
  /// constructors.
  public /*JBIT unsigned int*/ boolean SuppressTemplateArgsInCXXConstructors /*: 1*/;
  
  /// \brief Whether we can use 'bool' rather than '_Bool' (even if the language
  /// doesn't actually have 'bool', because, e.g., it is defined as a macro).
  public /*JBIT unsigned int*/ boolean Bool /*: 1*/;
  
  /// \brief Whether we can use 'restrict' rather than '__restrict'.
  public /*JBIT unsigned int*/ boolean Restrict /*: 1*/;
  
  /// \brief Whether we can use 'alignof' rather than '__alignof'.
  public /*JBIT unsigned int*/ boolean Alignof /*: 1*/;
  
  /// \brief Whether we can use '_Alignof' rather than '__alignof'.
  public /*JBIT unsigned int*/ boolean UnderscoreAlignof /*: 1*/;
  
  /// \brief Whether we should use '(void)' rather than '()' for a function
  /// prototype with zero parameters.
  public /*JBIT unsigned int*/ boolean UseVoidForZeroParams /*: 1*/;
  
  /// \brief Provide a 'terse' output.
  ///
  /// For example, in this mode we don't print function bodies, class members,
  /// declarations inside namespaces etc.  Effectively, this should print
  /// only the requested declaration.
  public /*JBIT unsigned int*/ boolean TerseOutput /*: 1*/;
  
  /// \brief When true, do certain refinement needed for producing proper
  /// declaration tag; such as, do not print attributes attached to the declaration.
  ///
  public /*JBIT unsigned int*/ boolean PolishForDeclaration /*: 1*/;
  
  /// \brief When true, print the half-precision floating-point type as 'half'
  /// instead of '__fp16'
  public /*JBIT unsigned int*/ boolean Half /*: 1*/;
  
  /// \brief When true, print the built-in wchar_t type as __wchar_t. For use in
  /// Microsoft mode when wchar_t is not available.
  public /*JBIT unsigned int*/ boolean MSWChar /*: 1*/;
  
  /// \brief When true, include newlines after statements like "break", etc.
  public /*JBIT unsigned int*/ boolean IncludeNewlines /*: 1*/;
  
  /// \brief Use whitespace and punctuation like MSVC does. In particular, this
  /// prints anonymous namespaces as `anonymous namespace' and does not insert
  /// spaces after template arguments.
  public /*JBIT bool*/ boolean MSVCFormatting /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 38,
   FQN="clang::PrintingPolicy::operator=", NM="_ZN5clang14PrintingPolicyaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicyaSERKS0_")
  //</editor-fold>
  public /*inline*/ PrintingPolicy /*&*/ $assign(final /*const*/ PrintingPolicy /*&*/ $Prm0) {
    this.Indentation = $uint2uint_8bits($Prm0.Indentation);
    this.SuppressSpecifiers = $Prm0.SuppressSpecifiers;
    this.SuppressTagKeyword = $Prm0.SuppressTagKeyword;
    this.IncludeTagDefinition = $Prm0.IncludeTagDefinition;
    this.SuppressScope = $Prm0.SuppressScope;
    this.SuppressUnwrittenScope = $Prm0.SuppressUnwrittenScope;
    this.SuppressInitializers = $Prm0.SuppressInitializers;
    this.ConstantArraySizeAsWritten = $Prm0.ConstantArraySizeAsWritten;
    this.AnonymousTagLocations = $Prm0.AnonymousTagLocations;
    this.SuppressStrongLifetime = $Prm0.SuppressStrongLifetime;
    this.SuppressLifetimeQualifiers = $Prm0.SuppressLifetimeQualifiers;
    this.SuppressTemplateArgsInCXXConstructors = $Prm0.SuppressTemplateArgsInCXXConstructors;
    this.Bool = $Prm0.Bool;
    this.Restrict = $Prm0.Restrict;
    this.Alignof = $Prm0.Alignof;
    this.UnderscoreAlignof = $Prm0.UnderscoreAlignof;
    this.UseVoidForZeroParams = $Prm0.UseVoidForZeroParams;
    this.TerseOutput = $Prm0.TerseOutput;
    this.PolishForDeclaration = $Prm0.PolishForDeclaration;
    this.Half = $Prm0.Half;
    this.MSWChar = $Prm0.MSWChar;
    this.IncludeNewlines = $Prm0.IncludeNewlines;
    this.MSVCFormatting = $Prm0.MSVCFormatting;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy::PrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 38,
   FQN="clang::PrintingPolicy::PrintingPolicy", NM="_ZN5clang14PrintingPolicyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PrintingPolicy(final /*const*/ PrintingPolicy /*&*/ $Prm0) {
    // : Indentation(.Indentation), SuppressSpecifiers(.SuppressSpecifiers), SuppressTagKeyword(.SuppressTagKeyword), IncludeTagDefinition(.IncludeTagDefinition), SuppressScope(.SuppressScope), SuppressUnwrittenScope(.SuppressUnwrittenScope), SuppressInitializers(.SuppressInitializers), ConstantArraySizeAsWritten(.ConstantArraySizeAsWritten), AnonymousTagLocations(.AnonymousTagLocations), SuppressStrongLifetime(.SuppressStrongLifetime), SuppressLifetimeQualifiers(.SuppressLifetimeQualifiers), SuppressTemplateArgsInCXXConstructors(.SuppressTemplateArgsInCXXConstructors), Bool(.Bool), Restrict(.Restrict), Alignof(.Alignof), UnderscoreAlignof(.UnderscoreAlignof), UseVoidForZeroParams(.UseVoidForZeroParams), TerseOutput(.TerseOutput), PolishForDeclaration(.PolishForDeclaration), Half(.Half), MSWChar(.MSWChar), IncludeNewlines(.IncludeNewlines), MSVCFormatting(.MSVCFormatting) 
    //START JInit
    this.Indentation = $uint2uint_8bits($Prm0.Indentation);
    this.SuppressSpecifiers = $Prm0.SuppressSpecifiers;
    this.SuppressTagKeyword = $Prm0.SuppressTagKeyword;
    this.IncludeTagDefinition = $Prm0.IncludeTagDefinition;
    this.SuppressScope = $Prm0.SuppressScope;
    this.SuppressUnwrittenScope = $Prm0.SuppressUnwrittenScope;
    this.SuppressInitializers = $Prm0.SuppressInitializers;
    this.ConstantArraySizeAsWritten = $Prm0.ConstantArraySizeAsWritten;
    this.AnonymousTagLocations = $Prm0.AnonymousTagLocations;
    this.SuppressStrongLifetime = $Prm0.SuppressStrongLifetime;
    this.SuppressLifetimeQualifiers = $Prm0.SuppressLifetimeQualifiers;
    this.SuppressTemplateArgsInCXXConstructors = $Prm0.SuppressTemplateArgsInCXXConstructors;
    this.Bool = $Prm0.Bool;
    this.Restrict = $Prm0.Restrict;
    this.Alignof = $Prm0.Alignof;
    this.UnderscoreAlignof = $Prm0.UnderscoreAlignof;
    this.UseVoidForZeroParams = $Prm0.UseVoidForZeroParams;
    this.TerseOutput = $Prm0.TerseOutput;
    this.PolishForDeclaration = $Prm0.PolishForDeclaration;
    this.Half = $Prm0.Half;
    this.MSWChar = $Prm0.MSWChar;
    this.IncludeNewlines = $Prm0.IncludeNewlines;
    this.MSVCFormatting = $Prm0.MSVCFormatting;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintingPolicy::PrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/PrettyPrinter.h", line = 38,
   FQN="clang::PrintingPolicy::PrintingPolicy", NM="_ZN5clang14PrintingPolicyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang14PrintingPolicyC1EOS0_")
  //</editor-fold>
  public /*inline*/ PrintingPolicy(JD$Move _dparam, final PrintingPolicy /*&&*/$Prm0) {
    // : Indentation(static_cast<PrintingPolicy &&>().Indentation), SuppressSpecifiers(static_cast<PrintingPolicy &&>().SuppressSpecifiers), SuppressTagKeyword(static_cast<PrintingPolicy &&>().SuppressTagKeyword), IncludeTagDefinition(static_cast<PrintingPolicy &&>().IncludeTagDefinition), SuppressScope(static_cast<PrintingPolicy &&>().SuppressScope), SuppressUnwrittenScope(static_cast<PrintingPolicy &&>().SuppressUnwrittenScope), SuppressInitializers(static_cast<PrintingPolicy &&>().SuppressInitializers), ConstantArraySizeAsWritten(static_cast<PrintingPolicy &&>().ConstantArraySizeAsWritten), AnonymousTagLocations(static_cast<PrintingPolicy &&>().AnonymousTagLocations), SuppressStrongLifetime(static_cast<PrintingPolicy &&>().SuppressStrongLifetime), SuppressLifetimeQualifiers(static_cast<PrintingPolicy &&>().SuppressLifetimeQualifiers), SuppressTemplateArgsInCXXConstructors(static_cast<PrintingPolicy &&>().SuppressTemplateArgsInCXXConstructors), Bool(static_cast<PrintingPolicy &&>().Bool), Restrict(static_cast<PrintingPolicy &&>().Restrict), Alignof(static_cast<PrintingPolicy &&>().Alignof), UnderscoreAlignof(static_cast<PrintingPolicy &&>().UnderscoreAlignof), UseVoidForZeroParams(static_cast<PrintingPolicy &&>().UseVoidForZeroParams), TerseOutput(static_cast<PrintingPolicy &&>().TerseOutput), PolishForDeclaration(static_cast<PrintingPolicy &&>().PolishForDeclaration), Half(static_cast<PrintingPolicy &&>().Half), MSWChar(static_cast<PrintingPolicy &&>().MSWChar), IncludeNewlines(static_cast<PrintingPolicy &&>().IncludeNewlines), MSVCFormatting(static_cast<PrintingPolicy &&>().MSVCFormatting) 
    //START JInit
    this.Indentation = $uint2uint_8bits($Prm0.Indentation);
    this.SuppressSpecifiers = $Prm0.SuppressSpecifiers;
    this.SuppressTagKeyword = $Prm0.SuppressTagKeyword;
    this.IncludeTagDefinition = $Prm0.IncludeTagDefinition;
    this.SuppressScope = $Prm0.SuppressScope;
    this.SuppressUnwrittenScope = $Prm0.SuppressUnwrittenScope;
    this.SuppressInitializers = $Prm0.SuppressInitializers;
    this.ConstantArraySizeAsWritten = $Prm0.ConstantArraySizeAsWritten;
    this.AnonymousTagLocations = $Prm0.AnonymousTagLocations;
    this.SuppressStrongLifetime = $Prm0.SuppressStrongLifetime;
    this.SuppressLifetimeQualifiers = $Prm0.SuppressLifetimeQualifiers;
    this.SuppressTemplateArgsInCXXConstructors = $Prm0.SuppressTemplateArgsInCXXConstructors;
    this.Bool = $Prm0.Bool;
    this.Restrict = $Prm0.Restrict;
    this.Alignof = $Prm0.Alignof;
    this.UnderscoreAlignof = $Prm0.UnderscoreAlignof;
    this.UseVoidForZeroParams = $Prm0.UseVoidForZeroParams;
    this.TerseOutput = $Prm0.TerseOutput;
    this.PolishForDeclaration = $Prm0.PolishForDeclaration;
    this.Half = $Prm0.Half;
    this.MSWChar = $Prm0.MSWChar;
    this.IncludeNewlines = $Prm0.IncludeNewlines;
    this.MSVCFormatting = $Prm0.MSVCFormatting;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Indentation=" + $uchar2uint(Indentation) // NOI18N
              + ", SuppressSpecifiers=" + SuppressSpecifiers // NOI18N
              + ", SuppressTagKeyword=" + SuppressTagKeyword // NOI18N
              + ", IncludeTagDefinition=" + IncludeTagDefinition // NOI18N
              + ", SuppressScope=" + SuppressScope // NOI18N
              + ", SuppressUnwrittenScope=" + SuppressUnwrittenScope // NOI18N
              + ", SuppressInitializers=" + SuppressInitializers // NOI18N
              + ", ConstantArraySizeAsWritten=" + ConstantArraySizeAsWritten // NOI18N
              + ", AnonymousTagLocations=" + AnonymousTagLocations // NOI18N
              + ", SuppressStrongLifetime=" + SuppressStrongLifetime // NOI18N
              + ", SuppressLifetimeQualifiers=" + SuppressLifetimeQualifiers // NOI18N
              + ", SuppressTemplateArgsInCXXConstructors=" + SuppressTemplateArgsInCXXConstructors // NOI18N
              + ", Bool=" + Bool // NOI18N
              + ", Restrict=" + Restrict // NOI18N
              + ", Alignof=" + Alignof // NOI18N
              + ", UnderscoreAlignof=" + UnderscoreAlignof // NOI18N
              + ", UseVoidForZeroParams=" + UseVoidForZeroParams // NOI18N
              + ", TerseOutput=" + TerseOutput // NOI18N
              + ", PolishForDeclaration=" + PolishForDeclaration // NOI18N
              + ", Half=" + Half // NOI18N
              + ", MSWChar=" + MSWChar // NOI18N
              + ", IncludeNewlines=" + IncludeNewlines // NOI18N
              + ", MSVCFormatting=" + MSVCFormatting; // NOI18N
  }
}
