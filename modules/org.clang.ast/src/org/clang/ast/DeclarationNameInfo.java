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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.AstClangGlobals.*;

// struct DeclarationNameLoc

/// DeclarationNameInfo - A collector data type for bundling together
/// a DeclarationName and the correspnding source/type location info.
//<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 433,
 FQN="clang::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfoE")
//</editor-fold>
public class/*struct*/ DeclarationNameInfo {
/*private:*/
  /// Name - The declaration name, also encoding name kind.
  private DeclarationName Name;
  /// Loc - The main source location for the declaration name.
  private SourceLocation NameLoc;
  /// Info - Further source/type location info for special kinds of names.
  private DeclarationNameLoc LocInfo;
/*public:*/
  // FIXME: remove it.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::DeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 444,
   FQN="clang::DeclarationNameInfo::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfoC1Ev")
  //</editor-fold>
  public DeclarationNameInfo() {
    // : Name(), NameLoc(), LocInfo() 
    //START JInit
    this.Name = new DeclarationName();
    this.NameLoc = new SourceLocation();
    this.LocInfo = new DeclarationNameLoc();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::DeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 446,
   FQN="clang::DeclarationNameInfo::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoC1ENS_15DeclarationNameENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfoC1ENS_15DeclarationNameENS_14SourceLocationE")
  //</editor-fold>
  public DeclarationNameInfo(DeclarationName Name, SourceLocation NameLoc) {
    // : Name(Name), NameLoc(NameLoc), LocInfo(Name) 
    //START JInit
    this.Name = new DeclarationName(Name);
    this.NameLoc = new SourceLocation(NameLoc);
    this.LocInfo = new DeclarationNameLoc(new DeclarationName(Name));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::DeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 449,
   FQN="clang::DeclarationNameInfo::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoC1ENS_15DeclarationNameENS_14SourceLocationENS_18DeclarationNameLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfoC1ENS_15DeclarationNameENS_14SourceLocationENS_18DeclarationNameLocE")
  //</editor-fold>
  public DeclarationNameInfo(DeclarationName Name, SourceLocation NameLoc, 
      DeclarationNameLoc LocInfo) {
    // : Name(Name), NameLoc(NameLoc), LocInfo(LocInfo) 
    //START JInit
    this.Name = new DeclarationName(Name);
    this.NameLoc = new SourceLocation(NameLoc);
    this.LocInfo = new DeclarationNameLoc(LocInfo);
    //END JInit
  }

  
  /// getName - Returns the embedded declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 454,
   FQN="clang::DeclarationNameInfo::getName", NM="_ZNK5clang19DeclarationNameInfo7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo7getNameEv")
  //</editor-fold>
  public DeclarationName getName() /*const*/ {
    return new DeclarationName(Name);
  }

  /// setName - Sets the embedded declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 456,
   FQN="clang::DeclarationNameInfo::setName", NM="_ZN5clang19DeclarationNameInfo7setNameENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo7setNameENS_15DeclarationNameE")
  //</editor-fold>
  public void setName(DeclarationName N) {
    Name.$assign(N);
  }

  
  /// getLoc - Returns the main location of the declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 459,
   FQN="clang::DeclarationNameInfo::getLoc", NM="_ZNK5clang19DeclarationNameInfo6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo6getLocEv")
  //</editor-fold>
  public SourceLocation getLoc() /*const*/ {
    return new SourceLocation(NameLoc);
  }

  /// setLoc - Sets the main location of the declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 461,
   FQN="clang::DeclarationNameInfo::setLoc", NM="_ZN5clang19DeclarationNameInfo6setLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo6setLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLoc(SourceLocation L) {
    NameLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 463,
   FQN="clang::DeclarationNameInfo::getInfo", NM="_ZNK5clang19DeclarationNameInfo7getInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo7getInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameLoc /*&*/ getInfo$Const() /*const*/ {
    return LocInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 464,
   FQN="clang::DeclarationNameInfo::getInfo", NM="_ZN5clang19DeclarationNameInfo7getInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo7getInfoEv")
  //</editor-fold>
  public DeclarationNameLoc /*&*/ getInfo() {
    return LocInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 465,
   FQN="clang::DeclarationNameInfo::setInfo", NM="_ZN5clang19DeclarationNameInfo7setInfoERKNS_18DeclarationNameLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo7setInfoERKNS_18DeclarationNameLocE")
  //</editor-fold>
  public void setInfo(final /*const*/ DeclarationNameLoc /*&*/ Info) {
    LocInfo.$assign(Info);
  }

  
  /// getNamedTypeInfo - Returns the source type info associated to
  /// the name. Assumes it is a constructor, destructor or conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getNamedTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 469,
   FQN="clang::DeclarationNameInfo::getNamedTypeInfo", NM="_ZNK5clang19DeclarationNameInfo16getNamedTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo16getNamedTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getNamedTypeInfo() /*const*/ {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXConstructorName || Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName || Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName);
    return LocInfo.Unnamed_field.NamedType.TInfo;
  }

  /// setNamedTypeInfo - Sets the source type info associated to
  /// the name. Assumes it is a constructor, destructor or conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setNamedTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 477,
   FQN="clang::DeclarationNameInfo::setNamedTypeInfo", NM="_ZN5clang19DeclarationNameInfo16setNamedTypeInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo16setNamedTypeInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setNamedTypeInfo(TypeSourceInfo /*P*/ TInfo) {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXConstructorName || Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName || Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName);
    LocInfo.Unnamed_field.NamedType.TInfo = TInfo;
  }

  
  /// getCXXOperatorNameRange - Gets the range of the operator name
  /// (without the operator keyword). Assumes it is a (non-literal) operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getCXXOperatorNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 486,
   FQN="clang::DeclarationNameInfo::getCXXOperatorNameRange", NM="_ZNK5clang19DeclarationNameInfo23getCXXOperatorNameRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo23getCXXOperatorNameRangeEv")
  //</editor-fold>
  public SourceRange getCXXOperatorNameRange() /*const*/ {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXOperatorName);
    return new SourceRange(SourceLocation.getFromRawEncoding(LocInfo.Unnamed_field.CXXOperatorName.BeginOpNameLoc), 
        SourceLocation.getFromRawEncoding(LocInfo.Unnamed_field.CXXOperatorName.EndOpNameLoc));
  }

  /// setCXXOperatorNameRange - Sets the range of the operator name
  /// (without the operator keyword). Assumes it is a C++ operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setCXXOperatorNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 495,
   FQN="clang::DeclarationNameInfo::setCXXOperatorNameRange", NM="_ZN5clang19DeclarationNameInfo23setCXXOperatorNameRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo23setCXXOperatorNameRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setCXXOperatorNameRange(SourceRange R) {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXOperatorName);
    LocInfo.Unnamed_field.CXXOperatorName.BeginOpNameLoc = R.getBegin().getRawEncoding();
    LocInfo.Unnamed_field.CXXOperatorName.EndOpNameLoc = R.getEnd().getRawEncoding();
  }

  
  /// getCXXLiteralOperatorNameLoc - Returns the location of the literal
  /// operator name (not the operator keyword).
  /// Assumes it is a literal operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getCXXLiteralOperatorNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 504,
   FQN="clang::DeclarationNameInfo::getCXXLiteralOperatorNameLoc", NM="_ZNK5clang19DeclarationNameInfo28getCXXLiteralOperatorNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo28getCXXLiteralOperatorNameLocEv")
  //</editor-fold>
  public SourceLocation getCXXLiteralOperatorNameLoc() /*const*/ {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXLiteralOperatorName);
    return SourceLocation.getFromRawEncoding(LocInfo.Unnamed_field.CXXLiteralOperatorName.OpNameLoc);
  }

  /// setCXXLiteralOperatorNameLoc - Sets the location of the literal
  /// operator name (not the operator keyword).
  /// Assumes it is a literal operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::setCXXLiteralOperatorNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 512,
   FQN="clang::DeclarationNameInfo::setCXXLiteralOperatorNameLoc", NM="_ZN5clang19DeclarationNameInfo28setCXXLiteralOperatorNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfo28setCXXLiteralOperatorNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setCXXLiteralOperatorNameLoc(SourceLocation Loc) {
    assert (Name.getNameKind() == DeclarationName.NameKind.CXXLiteralOperatorName);
    LocInfo.Unnamed_field.CXXLiteralOperatorName.OpNameLoc = Loc.getRawEncoding();
  }

  
  /// \brief Determine whether this name involves a template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::isInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 520,
   FQN="clang::DeclarationNameInfo::isInstantiationDependent", NM="_ZNK5clang19DeclarationNameInfo24isInstantiationDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo24isInstantiationDependentEv")
  //</editor-fold>
  public boolean isInstantiationDependent() /*const*/ {
    switch (Name.getNameKind()) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXOperatorName:
     case CXXLiteralOperatorName:
     case CXXUsingDirective:
      return false;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ TInfo = LocInfo.Unnamed_field.NamedType.TInfo;
        if ((TInfo != null)) {
          return TInfo.getType().$arrow().isInstantiationDependentType();
        }
      }
      
      return Name.getCXXNameType().$arrow().isInstantiationDependentType();
    }
    throw new llvm_unreachable("All name kinds handled.");
  }

  
  /// \brief Determine whether this name contains an unexpanded
  /// parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 498,
   FQN="clang::DeclarationNameInfo::containsUnexpandedParameterPack", NM="_ZNK5clang19DeclarationNameInfo31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    switch (Name.getNameKind()) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXOperatorName:
     case CXXLiteralOperatorName:
     case CXXUsingDirective:
      return false;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ TInfo = LocInfo.Unnamed_field.NamedType.TInfo;
        if ((TInfo != null)) {
          return TInfo.getType().$arrow().containsUnexpandedParameterPack();
        }
      }
      
      return Name.getCXXNameType().$arrow().containsUnexpandedParameterPack();
    }
    throw new llvm_unreachable("All name kinds handled.");
  }

  
  /// getAsString - Retrieve the human-readable string for this name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 542,
   FQN="clang::DeclarationNameInfo::getAsString", NM="_ZNK5clang19DeclarationNameInfo11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    raw_string_ostream OS = null;
    try {
      std.string Result/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Result);
      printName(OS);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// printName - Print the human-readable name to a stream.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::printName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 549,
   FQN="clang::DeclarationNameInfo::printName", NM="_ZNK5clang19DeclarationNameInfo9printNameERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo9printNameERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printName(final raw_ostream /*&*/ OS) /*const*/ {
    switch (Name.getNameKind()) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXOperatorName:
     case CXXLiteralOperatorName:
     case CXXUsingDirective:
      $out_raw_ostream_DeclarationName(OS, /*NO_COPY*/Name);
      return;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ TInfo = LocInfo.Unnamed_field.NamedType.TInfo;
        if ((TInfo != null)) {
          if (Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName) {
            OS.$out_char($$TILDE);
          } else if (Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName) {
            OS.$out(/*KEEP_STR*/"operator ");
          }
          LangOptions LO/*J*/= new LangOptions();
          LO.CPlusPlus = true;
          LO.Bool = true;
          OS.$out(TInfo.getType().getAsString(new PrintingPolicy(LO)));
        } else {
          $out_raw_ostream_DeclarationName(OS, /*NO_COPY*/Name);
        }
      }
      return;
    }
    throw new llvm_unreachable("Unexpected declaration name kind");
  }

  
  /// getBeginLoc - Retrieve the location of the first token.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 531,
   FQN="clang::DeclarationNameInfo::getBeginLoc", NM="_ZNK5clang19DeclarationNameInfo11getBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo11getBeginLocEv")
  //</editor-fold>
  public SourceLocation getBeginLoc() /*const*/ {
    return new SourceLocation(NameLoc);
  }

  /// getEndLoc - Retrieve the location of the last token.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 580,
   FQN="clang::DeclarationNameInfo::getEndLoc", NM="_ZNK5clang19DeclarationNameInfo9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    switch (Name.getNameKind()) {
     case Identifier:
      return new SourceLocation(NameLoc);
     case CXXOperatorName:
      {
        /*uint*/int raw = LocInfo.Unnamed_field.CXXOperatorName.EndOpNameLoc;
        return SourceLocation.getFromRawEncoding(raw);
      }
     case CXXLiteralOperatorName:
      {
        /*uint*/int raw = LocInfo.Unnamed_field.CXXLiteralOperatorName.OpNameLoc;
        return SourceLocation.getFromRawEncoding(raw);
      }
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ TInfo = LocInfo.Unnamed_field.NamedType.TInfo;
        if ((TInfo != null)) {
          return TInfo.getTypeLoc().getEndLoc();
        } else {
          return new SourceLocation(NameLoc);
        }
      }
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXUsingDirective:
      
      // DNInfo work in progress: FIXME.
      return new SourceLocation(NameLoc);
    }
    throw new llvm_unreachable("Unexpected declaration name kind");
  }

  /// getSourceRange - The range of the declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 535,
   FQN="clang::DeclarationNameInfo::getSourceRange", NM="_ZNK5clang19DeclarationNameInfo14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(getLocStart(), getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 538,
   FQN="clang::DeclarationNameInfo::getLocStart", NM="_ZNK5clang19DeclarationNameInfo11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBeginLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 541,
   FQN="clang::DeclarationNameInfo::getLocEnd", NM="_ZNK5clang19DeclarationNameInfo9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang19DeclarationNameInfo9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    SourceLocation EndLoc = getEndLoc();
    return EndLoc.isValid() ? new SourceLocation(EndLoc) : getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::DeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 433,
   FQN="clang::DeclarationNameInfo::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang19DeclarationNameInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameInfo(JD$Move _dparam, final DeclarationNameInfo /*&&*/$Prm0) {
    // : Name(static_cast<DeclarationNameInfo &&>().Name), NameLoc(static_cast<DeclarationNameInfo &&>().NameLoc), LocInfo(static_cast<DeclarationNameInfo &&>().LocInfo) 
    //START JInit
    this.Name = new DeclarationName(JD$Move.INSTANCE, $Prm0.Name);
    this.NameLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.NameLoc);
    this.LocInfo = new DeclarationNameLoc(JD$Move.INSTANCE, $Prm0.LocInfo);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::DeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 433,
   FQN="clang::DeclarationNameInfo::DeclarationNameInfo", NM="_ZN5clang19DeclarationNameInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang19DeclarationNameInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameInfo(final /*const*/ DeclarationNameInfo /*&*/ $Prm0) {
    // : Name(.Name), NameLoc(.NameLoc), LocInfo(.LocInfo) 
    //START JInit
    this.Name = new DeclarationName($Prm0.Name);
    this.NameLoc = new SourceLocation($Prm0.NameLoc);
    this.LocInfo = new DeclarationNameLoc($Prm0.LocInfo);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 433,
   FQN="clang::DeclarationNameInfo::operator=", NM="_ZN5clang19DeclarationNameInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang19DeclarationNameInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameInfo /*&*/ $assign(final /*const*/ DeclarationNameInfo /*&*/ $Prm0) {
    this.Name.$assign($Prm0.Name);
    this.NameLoc.$assign($Prm0.NameLoc);
    this.LocInfo.$assign($Prm0.LocInfo);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameInfo::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 433,
   FQN="clang::DeclarationNameInfo::operator=", NM="_ZN5clang19DeclarationNameInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang19DeclarationNameInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameInfo /*&*/ $assignMove(final DeclarationNameInfo /*&&*/$Prm0) {
    assert this != $Prm0;
    this.Name.$assignMove($Prm0.Name);
    $Prm0.Name = null;
    this.NameLoc.$assignMove($Prm0.NameLoc);
    $Prm0.NameLoc = null;
    this.LocInfo.$assignMove($Prm0.LocInfo);
    $Prm0.LocInfo = null;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", NameLoc=" + NameLoc // NOI18N
              + ", LocInfo=" + LocInfo; // NOI18N
  }
}
