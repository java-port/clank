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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.impl.NestedNameSpecifierStatics.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief A C++ nested-name-specifier augmented with source location
/// information.
//<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 226,
 FQN="clang::NestedNameSpecifierLoc", NM="_ZN5clang22NestedNameSpecifierLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocE")
//</editor-fold>
public class NestedNameSpecifierLoc implements Native.ComparableLower, Native.Native$Bool, NativePOD<NestedNameSpecifierLoc> {
  private NestedNameSpecifier /*P*/ Qualifier;
  private type$ptr<?>/*void P*/ Data;
  
  /// \brief Determines the data length for the last component in the
  /// given nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getLocalDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*size*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 339,
   FQN="clang::NestedNameSpecifierLoc::getLocalDataLength", NM="_ZN5clang22NestedNameSpecifierLoc18getLocalDataLengthEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLoc18getLocalDataLengthEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  private static /*uint*/int getLocalDataLength(NestedNameSpecifier /*P*/ Qualifier) {
    assert ((Qualifier != null)) : "Expected a non-NULL qualifier";
    // JAVA: data is stored in array of Objects in Java, so everything 
    // has size = 1
    
    // Location of the trailing '::'.
    /*uint*/int Length = /*JAVA*/true ? 1 : $sizeof_UInt();
    switch (Qualifier.getKind()) {
     case Global:
      // Nothing more to add.
      break;
     case Identifier:
     case Namespace:
     case NamespaceAlias:
     case Super:
      // The location of the identifier or namespace name.
      Length += /*JAVA*/true ? 1 : $sizeof_UInt();
      break;
     case TypeSpecWithTemplate:
     case TypeSpec:
      // The "void*" that points at the TypeLoc data.
      // Note: the 'template' keyword is part of the TypeLoc.
      Length += /*JAVA*/true ? 1 : $sizeof_ptr(/*Object */);
      break;
    }
    
    return Length;
  }

  
  /// \brief Determines the data length for the entire
  /// nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getDataLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 370,
   FQN="clang::NestedNameSpecifierLoc::getDataLength", NM="_ZN5clang22NestedNameSpecifierLoc13getDataLengthEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLoc13getDataLengthEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  private static /*uint*/int getDataLength(NestedNameSpecifier /*P*/ Qualifier) {
    /*uint*/int Length = 0;
    for (; (Qualifier != null); Qualifier = Qualifier.getPrefix())  {
      Length += getLocalDataLength(Qualifier);
    }
    return Length;
  }

/*public:*/
  /// \brief Construct an empty nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 240,
   FQN="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc", NM="_ZN5clang22NestedNameSpecifierLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocC1Ev")
  //</editor-fold>
  public NestedNameSpecifierLoc() {
    // : Qualifier(null), Data(null) 
    //START JInit
    this.Qualifier = null;
    this.Data = null;
    //END JInit
  }

  
  /// \brief Construct a nested-name-specifier with source location information
  /// from
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 244,
   FQN="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc", NM="_ZN5clang22NestedNameSpecifierLocC1EPNS_19NestedNameSpecifierEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocC1EPNS_19NestedNameSpecifierEPv")
  //</editor-fold>
  public NestedNameSpecifierLoc(NestedNameSpecifier /*P*/ Qualifier, type$ptr<?>/*void P*/ Data) {
    // : Qualifier(Qualifier), Data(Data) 
    //START JInit
    this.Qualifier = Qualifier;
    this.Data = $toConst($tryClone(Data));
    //END JInit
  }

  
  /// \brief Evalutes true when this nested-name-specifier location is
  /// non-empty.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 249,
   FQN="clang::NestedNameSpecifierLoc::operator bool", NM="_ZNK5clang22NestedNameSpecifierLoccvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoccvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (Qualifier != null);
  }

  
  /// \brief Evalutes true when this nested-name-specifier location is
  /// empty.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::hasQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 253,
   FQN="clang::NestedNameSpecifierLoc::hasQualifier", NM="_ZNK5clang22NestedNameSpecifierLoc12hasQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc12hasQualifierEv")
  //</editor-fold>
  public boolean hasQualifier() /*const*/ {
    return (Qualifier != null);
  }

  
  /// \brief Retrieve the nested-name-specifier to which this instance
  /// refers.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 257,
   FQN="clang::NestedNameSpecifierLoc::getNestedNameSpecifier", NM="_ZNK5clang22NestedNameSpecifierLoc22getNestedNameSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc22getNestedNameSpecifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getNestedNameSpecifier() /*const*/ {
    return Qualifier;
  }

  
  /// \brief Retrieve the opaque pointer that refers to source-location data.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getOpaqueData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 262,
   FQN="clang::NestedNameSpecifierLoc::getOpaqueData", NM="_ZNK5clang22NestedNameSpecifierLoc13getOpaqueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc13getOpaqueDataEv")
  //</editor-fold>
  public type$ptr<?>/*void P*/ getOpaqueData() /*const*/ {
    return Data;
  }

  
  /// \brief Retrieve the source range covering the entirety of this
  /// nested-name-specifier.
  ///
  /// For example, if this instance refers to a nested-name-specifier
  /// \c \::std::vector<int>::, the returned source range would cover
  /// from the initial '::' to the last '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 396,
   FQN="clang::NestedNameSpecifierLoc::getSourceRange", NM="_ZNK5clang22NestedNameSpecifierLoc14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    if (!(Qualifier != null)) {
      return new SourceRange();
    }
    
    NestedNameSpecifierLoc First = new NestedNameSpecifierLoc(/*Deref*/this);
    {
      NestedNameSpecifierLoc Prefix;
      while ((Prefix = First.getPrefix()).$bool()) {
        First.$assign(Prefix);
      }
    }
    
    return new SourceRange(First.getLocalSourceRange().getBegin(), 
        getLocalSourceRange().getEnd());
  }

  
  /// \brief Retrieve the source range covering just the last part of
  /// this nested-name-specifier, not including the prefix.
  ///
  /// For example, if this instance refers to a nested-name-specifier
  /// \c \::std::vector<int>::, the returned source range would cover
  /// from "vector" to the last '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 408,
   FQN="clang::NestedNameSpecifierLoc::getLocalSourceRange", NM="_ZNK5clang22NestedNameSpecifierLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (!(Qualifier != null)) {
      return new SourceRange();
    }
    
    /*uint*/int Offset = getDataLength(Qualifier.getPrefix());
    switch (Qualifier.getKind()) {
     case Global:
      return new SourceRange(LoadSourceLocation(Data, Offset));
     case Identifier:
     case Namespace:
     case NamespaceAlias:
     case Super:
      return new SourceRange(LoadSourceLocation(Data, Offset), 
          LoadSourceLocation(Data, Offset + (true ? 1 : $sizeof_UInt())));
     case TypeSpecWithTemplate:
     case TypeSpec:
      {
        // The "void*" that points at the TypeLoc data.
        // Note: the 'template' keyword is part of the TypeLoc.
        type$ptr<?/*void P*/> TypeData = (type$ptr<?/*void P*/>) LoadPointer(Data, Offset);
        TypeLoc TL/*J*/= new TypeLoc(Qualifier.getAsType(), TypeData);
        return new SourceRange(TL.getBeginLoc(), 
            LoadSourceLocation(Data, Offset + (true ? 1 : $sizeof_ptr(/*Object */))));
      }
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Retrieve the location of the beginning of this
  /// nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 282,
   FQN="clang::NestedNameSpecifierLoc::getBeginLoc", NM="_ZNK5clang22NestedNameSpecifierLoc11getBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc11getBeginLocEv")
  //</editor-fold>
  public SourceLocation getBeginLoc() /*const*/ {
    return getSourceRange().getBegin();
  }

  
  /// \brief Retrieve the location of the end of this
  /// nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 288,
   FQN="clang::NestedNameSpecifierLoc::getEndLoc", NM="_ZNK5clang22NestedNameSpecifierLoc9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return getSourceRange().getEnd();
  }

  
  /// \brief Retrieve the location of the beginning of this
  /// component of the nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getLocalBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 294,
   FQN="clang::NestedNameSpecifierLoc::getLocalBeginLoc", NM="_ZNK5clang22NestedNameSpecifierLoc16getLocalBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc16getLocalBeginLocEv")
  //</editor-fold>
  public SourceLocation getLocalBeginLoc() /*const*/ {
    return getLocalSourceRange().getBegin();
  }

  
  /// \brief Retrieve the location of the end of this component of the
  /// nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getLocalEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 300,
   FQN="clang::NestedNameSpecifierLoc::getLocalEndLoc", NM="_ZNK5clang22NestedNameSpecifierLoc14getLocalEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc14getLocalEndLocEv")
  //</editor-fold>
  public SourceLocation getLocalEndLoc() /*const*/ {
    return getLocalSourceRange().getEnd();
  }

  
  /// \brief Return the prefix of this nested-name-specifier.
  ///
  /// For example, if this instance refers to a nested-name-specifier
  /// \c \::std::vector<int>::, the prefix is \c \::std::. Note that the
  /// returned prefix may be empty, if this is the first component of
  /// the nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 310,
   FQN="clang::NestedNameSpecifierLoc::getPrefix", NM="_ZNK5clang22NestedNameSpecifierLoc9getPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc9getPrefixEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getPrefix() /*const*/ {
    if (!(Qualifier != null)) {
      return new NestedNameSpecifierLoc(/*Deref*/this);
    }
    
    return new NestedNameSpecifierLoc(Qualifier.getPrefix(), Data);
  }

  
  /// \brief For a nested-name-specifier that refers to a type,
  /// retrieve the type with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 438,
   FQN="clang::NestedNameSpecifierLoc::getTypeLoc", NM="_ZNK5clang22NestedNameSpecifierLoc10getTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc10getTypeLocEv")
  //</editor-fold>
  public TypeLoc getTypeLoc() /*const*/ {
    assert ((Qualifier.getKind() == NestedNameSpecifier.SpecifierKind.TypeSpec || Qualifier.getKind() == NestedNameSpecifier.SpecifierKind.TypeSpecWithTemplate)) : "Nested-name-specifier location is not a type";
    
    // The "void*" that points at the TypeLoc data.
    /*uint*/int Offset = getDataLength(Qualifier.getPrefix());
    type$ptr<?/*void P*/>  TypeData = (type$ptr<?/*void P*/>) LoadPointer(Data, Offset);
    return new TypeLoc(Qualifier.getAsType(), TypeData);
  }

  
  /// \brief Determines the data length for the entire
  /// nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::getDataLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 323,
   FQN="clang::NestedNameSpecifierLoc::getDataLength", NM="_ZNK5clang22NestedNameSpecifierLoc13getDataLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang22NestedNameSpecifierLoc13getDataLengthEv")
  //</editor-fold>
  public /*uint*/int getDataLength() /*const*/ {
    return getDataLength(Qualifier);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 325,
   FQN="clang::operator==", NM="_ZN5clangeqENS_22NestedNameSpecifierLocES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clangeqENS_22NestedNameSpecifierLocES0_")
  //</editor-fold>
  public static boolean $eq_NestedNameSpecifierLoc(NestedNameSpecifierLoc X, 
                            NestedNameSpecifierLoc Y) {
    return X.Qualifier == Y.Qualifier && $eq_ptr(X.Data, Y.Data);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 330,
   FQN="clang::operator!=", NM="_ZN5clangneENS_22NestedNameSpecifierLocES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clangneENS_22NestedNameSpecifierLocES0_")
  //</editor-fold>
  public static boolean $noteq_NestedNameSpecifierLoc(NestedNameSpecifierLoc X, 
                               NestedNameSpecifierLoc Y) {
    return !($eq_NestedNameSpecifierLoc(/*NO_COPY*/X, /*NO_COPY*/Y));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 226,
   FQN="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc", NM="_ZN5clang22NestedNameSpecifierLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ NestedNameSpecifierLoc(final /*const*/ NestedNameSpecifierLoc /*&*/ $Prm0) {
    // : Qualifier(.Qualifier), Data(.Data) 
    //START JInit
    this.Qualifier = $Prm0.Qualifier;
    this.Data = $tryClone($Prm0.Data);
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 226,
   FQN="clang::NestedNameSpecifierLoc::NestedNameSpecifierLoc", NM="_ZN5clang22NestedNameSpecifierLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ NestedNameSpecifierLoc(JD$Move _dparam, final NestedNameSpecifierLoc /*&&*/$Prm0) {
    // : Qualifier(static_cast<NestedNameSpecifierLoc &&>().Qualifier), Data(static_cast<NestedNameSpecifierLoc &&>().Data) 
    //START JInit
    this.Qualifier = $Prm0.Qualifier;
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 226,
   FQN="clang::NestedNameSpecifierLoc::operator=", NM="_ZN5clang22NestedNameSpecifierLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang22NestedNameSpecifierLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ NestedNameSpecifierLoc /*&*/ $assign(final /*const*/ NestedNameSpecifierLoc /*&*/ $Prm0) {
    this.Qualifier = $Prm0.Qualifier;
    this.Data = $tryClone($Prm0.Data);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 226,
   FQN="clang::NestedNameSpecifierLoc::operator=", NM="_ZN5clang22NestedNameSpecifierLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang22NestedNameSpecifierLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ NestedNameSpecifierLoc /*&*/ $assignMove(final NestedNameSpecifierLoc /*&&*/$Prm0) {
    this.Qualifier = $Prm0.Qualifier;
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public boolean $less(Object obj) { 
    if (this == obj) return false;
    NestedNameSpecifierLoc other = (NestedNameSpecifierLoc) obj;
    boolean out = Native.$less$JavaRef(this.Qualifier, other.Qualifier);
    return out || Native.$less(this.Data, other.Data);
  }

  @Override
  public NestedNameSpecifierLoc clone() {
    return new NestedNameSpecifierLoc(this);
  }

  @Override
  public boolean $eq(NestedNameSpecifierLoc other) {
    return $eq_NestedNameSpecifierLoc(this, other);
  }

  public /*inline*/ NestedNameSpecifierLoc(type$ptr<?> This$Mem, final /*const*/ NestedNameSpecifierLoc /*&*/ $Prm0) {
    // : Qualifier(.Qualifier), Data(.Data) 
    //START JInit
    TrailingObjectsUtils.$putThisAndShift(this, This$Mem);
    this.Qualifier = $Prm0.Qualifier;
    this.Data = $tryClone($Prm0.Data);
    //END JInit
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Qualifier=" + Qualifier // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
