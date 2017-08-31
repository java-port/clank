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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.impl.VersionTupleStatics.parseInt;
import static org.llvm.adt.NoneType.None;


/// \brief Represents a version number in the form major[.minor[.subminor[.build]]].
//<editor-fold defaultstate="collapsed" desc="clang::VersionTuple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 26,
 FQN="clang::VersionTuple", NM="_ZN5clang12VersionTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleE")
//</editor-fold>
public class VersionTuple {
  /*friend*/ /*uint*/int Major /*: 31*/;
  
  private /*JBIT unsigned int*/ boolean UsesUnderscores /*: 1*/;
  
  /*friend*/ /*uint*/int Minor /*: 31*/;
  private /*JBIT unsigned int*/ boolean HasMinor /*: 1*/;
  
  /*friend*/ /*uint*/int Subminor /*: 31*/;
  private /*JBIT unsigned int*/ boolean HasSubminor /*: 1*/;
  
  /*friend*/ /*uint*/int Build /*: 31*/;
  private /*JBIT unsigned int*/ boolean HasBuild /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 37,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1Ev")
  //</editor-fold>
  public VersionTuple() {
    /* : Major(0), UsesUnderscores(false), Minor(0), HasMinor(false), Subminor(0), HasSubminor(false), Build(0), HasBuild(false)*/ 
    //START JInit
    this.Major = 0;
    this.UsesUnderscores = false;
    this.Minor = 0;
    this.HasMinor = false;
    this.Subminor = 0;
    this.HasSubminor = false;
    this.Build = 0;
    this.HasBuild = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 41,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1Ej")
  //</editor-fold>
  public /*explicit*/ VersionTuple(/*uint*/int Major) {
    /* : Major(Major), UsesUnderscores(false), Minor(0), HasMinor(false), Subminor(0), HasSubminor(false), Build(0), HasBuild(false)*/ 
    //START JInit
    this.Major = Major;
    this.UsesUnderscores = false;
    this.Minor = 0;
    this.HasMinor = false;
    this.Subminor = 0;
    this.HasSubminor = false;
    this.Build = 0;
    this.HasBuild = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 45,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1Ejjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1Ejjb")
  //</editor-fold>
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor) {
    this(Major, Minor, 
      false);
  }
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor, 
      boolean UsesUnderscores/*= false*/) {
    /* : Major(Major), UsesUnderscores(UsesUnderscores), Minor(Minor), HasMinor(true), Subminor(0), HasSubminor(false), Build(0), HasBuild(false)*/ 
    //START JInit
    this.Major = Major;
    this.UsesUnderscores = UsesUnderscores;
    this.Minor = Minor;
    this.HasMinor = true;
    this.Subminor = 0;
    this.HasSubminor = false;
    this.Build = 0;
    this.HasBuild = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 55,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 50,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1Ejjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1Ejjjb")
  //</editor-fold>
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor, /*uint*/int Subminor) {
    this(Major, Minor, Subminor, 
      false);
  }
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor, /*uint*/int Subminor, 
      boolean UsesUnderscores/*= false*/) {
    /* : Major(Major), UsesUnderscores(UsesUnderscores), Minor(Minor), HasMinor(true), Subminor(Subminor), HasSubminor(true), Build(0), HasBuild(false)*/ 
    //START JInit
    this.Major = Major;
    this.UsesUnderscores = UsesUnderscores;
    this.Minor = Minor;
    this.HasMinor = true;
    this.Subminor = Subminor;
    this.HasSubminor = true;
    this.Build = 0;
    this.HasBuild = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 56,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1Ejjjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1Ejjjjb")
  //</editor-fold>
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor, /*uint*/int Subminor, 
      /*uint*/int Build) {
    this(Major, Minor, Subminor, 
      Build, false);
  }
  public /*explicit*/ VersionTuple(/*uint*/int Major, /*uint*/int Minor, /*uint*/int Subminor, 
      /*uint*/int Build, boolean UsesUnderscores/*= false*/) {
    /* : Major(Major), UsesUnderscores(UsesUnderscores), Minor(Minor), HasMinor(true), Subminor(Subminor), HasSubminor(true), Build(Build), HasBuild(true)*/ 
    //START JInit
    this.Major = Major;
    this.UsesUnderscores = UsesUnderscores;
    this.Minor = Minor;
    this.HasMinor = true;
    this.Subminor = Subminor;
    this.HasSubminor = true;
    this.Build = Build;
    this.HasBuild = true;
    //END JInit
  }

  
  /// \brief Determine whether this version information is empty
  /// (e.g., all version components are zero).
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 64,
   FQN="clang::VersionTuple::empty", NM="_ZNK5clang12VersionTuple5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Major == 0 && Minor == 0 && Subminor == 0 && Build == 0;
  }

  
  /// \brief Retrieve the major version number.
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::getMajor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 69,
   FQN="clang::VersionTuple::getMajor", NM="_ZNK5clang12VersionTuple8getMajorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple8getMajorEv")
  //</editor-fold>
  public /*uint*/int getMajor() /*const*/ {
    return Major;
  }

  
  /// \brief Retrieve the minor version number, if provided.
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::getMinor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 72,
   FQN="clang::VersionTuple::getMinor", NM="_ZNK5clang12VersionTuple8getMinorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple8getMinorEv")
  //</editor-fold>
  public OptionalUInt getMinor() /*const*/ {
    if (!HasMinor) {
      return new OptionalUInt(None);
    }
    return new OptionalUInt(Minor);
  }

  
  /// \brief Retrieve the subminor version number, if provided.
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::getSubminor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 79,
   FQN="clang::VersionTuple::getSubminor", NM="_ZNK5clang12VersionTuple11getSubminorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple11getSubminorEv")
  //</editor-fold>
  public OptionalUInt getSubminor() /*const*/ {
    if (!HasSubminor) {
      return new OptionalUInt(None);
    }
    return new OptionalUInt(Subminor);
  }

  
  /// \brief Retrieve the build version number, if provided.
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::getBuild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 86,
   FQN="clang::VersionTuple::getBuild", NM="_ZNK5clang12VersionTuple8getBuildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple8getBuildEv")
  //</editor-fold>
  public OptionalUInt getBuild() /*const*/ {
    if (!HasBuild) {
      return new OptionalUInt(None);
    }
    return new OptionalUInt(Build);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::usesUnderscores">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 92,
   FQN="clang::VersionTuple::usesUnderscores", NM="_ZNK5clang12VersionTuple15usesUnderscoresEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang12VersionTuple15usesUnderscoresEv")
  //</editor-fold>
  public boolean usesUnderscores() /*const*/ {
    return UsesUnderscores;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::UseDotAsSeparator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 96,
   FQN="clang::VersionTuple::UseDotAsSeparator", NM="_ZN5clang12VersionTuple17UseDotAsSeparatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTuple17UseDotAsSeparatorEv")
  //</editor-fold>
  public void UseDotAsSeparator() {
    UsesUnderscores = false;
  }

  
  /// \brief Determine if two version numbers are equivalent. If not
  /// provided, minor and subminor version numbers are considered to be zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 102,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangeqERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $eq_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    return X.Major == Y.Major && X.Minor == Y.Minor
       && X.Subminor == Y.Subminor && X.Build == Y.Build;
  }

  
  /// \brief Determine if two version numbers are not equivalent.
  ///
  /// If not provided, minor and subminor version numbers are considered to be 
  /// zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 111,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangneERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $noteq_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    return !($eq_VersionTuple$C(X, Y));
  }

  
  /// \brief Determine whether one version number precedes another.
  ///
  /// If not provided, minor and subminor version numbers are considered to be
  /// zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 119,
   FQN="clang::operator<", NM="_ZN5clangltERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangltERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $less_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    if (X.Major != Y.Major) {
      return Unsigned.$less_uint(X.Major, Y.Major);
    }    
    if (X.Minor != Y.Minor) {
      return Unsigned.$less_uint(X.Minor, Y.Minor);
    }    
    if (X.Subminor != Y.Subminor) {
      return Unsigned.$less_uint(X.Subminor, Y.Subminor);
    } 
    return Unsigned.$less_uint(X.Build, Y.Build);
  }

  
  /// \brief Determine whether one version number follows another.
  ///
  /// If not provided, minor and subminor version numbers are considered to be
  /// zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 128,
   FQN="clang::operator>", NM="_ZN5clanggtERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clanggtERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $greater_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    return $less_VersionTuple$C(Y, X);
  }

  
  /// \brief Determine whether one version number precedes or is
  /// equivalent to another. 
  ///
  /// If not provided, minor and subminor version numbers are considered to be
  /// zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 137,
   FQN="clang::operator<=", NM="_ZN5clangleERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clangleERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $lesseq_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    return !($less_VersionTuple$C(Y, X));
  }

  
  /// \brief Determine whether one version number follows or is
  /// equivalent to another.
  ///
  /// If not provided, minor and subminor version numbers are considered to be
  /// zero.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", old_line = 146,
   FQN="clang::operator>=", NM="_ZN5clanggeERKNS_12VersionTupleES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clanggeERKNS_12VersionTupleES2_")
  //</editor-fold>
  public static boolean $greatereq_VersionTuple$C(/*const*/ VersionTuple /*&*/ X, /*const*/ VersionTuple /*&*/ Y) {
    return !($less_VersionTuple$C(X, Y));
  }

  
  /// \brief Retrieve a string representation of the version number.
  
  /// \brief Retrieve a string representation of the version number.
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp", line = 19,
   FQN="clang::VersionTuple::getAsString", NM="_ZNK5clang12VersionTuple11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp -nm=_ZNK5clang12VersionTuple11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    std.string Result/*J*/= new std.string();
    {
      raw_string_ostream Out = null;
      try {
        Out/*J*/= new raw_string_ostream(Result);
       $out_raw_ostream_VersionTuple$C(Out, /*Deref*/this);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    return Result;
  }


  
  /// \brief Try to parse the given string as a version number.
  /// \returns \c true if the string does not match the regular expression
  ///   [0-9]+(\.[0-9]+){0,3}
  
  /// \brief Try to parse the given string as a version number.
  /// \returns \c true if the string does not match the regular expression
  ///   [0-9]+(\.[0-9]+){0,3}
  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::tryParse">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp", line = 59,
   FQN="clang::VersionTuple::tryParse", NM="_ZN5clang12VersionTuple8tryParseEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp -nm=_ZN5clang12VersionTuple8tryParseEN4llvm9StringRefE")
  //</editor-fold>
  public boolean tryParse(char$ptr input) {
    return tryParse(new StringRef(input));
  }
  public boolean tryParse(StringRef input) {
    /*uint*/uint$ref major = create_uint$ref(), minor = create_uint$ref(), 
            micro = create_uint$ref(), build = create_uint$ref();
    
    // Parse the major version, [0-9]+
    if (parseInt(input, major)) {
      return true;
    }
    if (input.empty()) {
      /*Deref*/this.$assignMove(new VersionTuple(major.$deref()));
      return false;
    }
    
    // If we're not done, parse the minor version, \.[0-9]+
    if (input.$at(0) != $$DOT) {
      return true;
    }
    input.$assignMove(input.substr(1));
    if (parseInt(input, minor)) {
      return true;
    }
    if (input.empty()) {
      /*Deref*/this.$assignMove(new VersionTuple(major.$deref(), minor.$deref()));
      return false;
    }
    
    // If we're not done, parse the micro version, \.[0-9]+
    if (input.$at(0) != $$DOT) {
      return true;
    }
    input.$assignMove(input.substr(1));
    if (parseInt(input, micro)) {
      return true;
    }
    if (input.empty()) {
      /*Deref*/this.$assignMove(new VersionTuple(major.$deref(), minor.$deref(), micro.$deref()));
      return false;
    }
    
    // If we're not done, parse the micro version, \.[0-9]+
    if (input.$at(0) != $$DOT) {
      return true;
    }
    input.$assignMove(input.substr(1));
    if (parseInt(input, build)) {
      return true;
    }
    
    // If we have characters left over, it's an error.
    if (!input.empty()) {
      return true;
    }
    
    /*Deref*/this.$assignMove(new VersionTuple(major.$deref(), minor.$deref(), micro.$deref(), build.$deref()));
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 26,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1ERKS0_")
  //</editor-fold>
  public /*inline*/ VersionTuple(/*const*/ VersionTuple /*&*/ $Prm0) {
    /* : Major(.Major), UsesUnderscores(.UsesUnderscores), Minor(.Minor), HasMinor(.HasMinor), Subminor(.Subminor), HasSubminor(.HasSubminor), Build(.Build), HasBuild(.HasBuild)*/ 
    //START JInit
    this.Major = $Prm0.Major;
    this.UsesUnderscores = $Prm0.UsesUnderscores;
    this.Minor = $Prm0.Minor;
    this.HasMinor = $Prm0.HasMinor;
    this.Subminor = $Prm0.Subminor;
    this.HasSubminor = $Prm0.HasSubminor;
    this.Build = $Prm0.Build;
    this.HasBuild = $Prm0.HasBuild;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::VersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 26,
   FQN="clang::VersionTuple::VersionTuple", NM="_ZN5clang12VersionTupleC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleC1EOS0_")
  //</editor-fold>
  public /*inline*/ VersionTuple(JD$Move _dparam, VersionTuple /*&&*/$Prm0) {
    /* : Major(static_cast<VersionTuple &&>().Major), UsesUnderscores(static_cast<VersionTuple &&>().UsesUnderscores), Minor(static_cast<VersionTuple &&>().Minor), HasMinor(static_cast<VersionTuple &&>().HasMinor), Subminor(static_cast<VersionTuple &&>().Subminor), HasSubminor(static_cast<VersionTuple &&>().HasSubminor), Build(static_cast<VersionTuple &&>().Build), HasBuild(static_cast<VersionTuple &&>().HasBuild)*/ 
    //START JInit
    this.Major = $Prm0.Major;
    this.UsesUnderscores = $Prm0.UsesUnderscores;
    this.Minor = $Prm0.Minor;
    this.HasMinor = $Prm0.HasMinor;
    this.Subminor = $Prm0.Subminor;
    this.HasSubminor = $Prm0.HasSubminor;
    this.Build = $Prm0.Build;
    this.HasBuild = $Prm0.HasBuild;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 26,
   FQN="clang::VersionTuple::operator=", NM="_ZN5clang12VersionTupleaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleaSERKS0_")
  //</editor-fold>
  public /*inline*/ VersionTuple /*&*/ $assign(/*const*/ VersionTuple /*&*/ $Prm0) {
    this.Major = $Prm0.Major;
    this.UsesUnderscores = $Prm0.UsesUnderscores;
    this.Minor = $Prm0.Minor;
    this.HasMinor = $Prm0.HasMinor;
    this.Subminor = $Prm0.Subminor;
    this.HasSubminor = $Prm0.HasSubminor;
    this.Build = $Prm0.Build;
    this.HasBuild = $Prm0.HasBuild;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VersionTuple::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VersionTuple.h", line = 26,
   FQN="clang::VersionTuple::operator=", NM="_ZN5clang12VersionTupleaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang12VersionTupleaSEOS0_")
  //</editor-fold>
  public /*inline*/ VersionTuple /*&*/ $assignMove(VersionTuple /*&&*/$Prm0) {
    this.Major = $Prm0.Major;
    this.UsesUnderscores = $Prm0.UsesUnderscores;
    this.Minor = $Prm0.Minor;
    this.HasMinor = $Prm0.HasMinor;
    this.Subminor = $Prm0.Subminor;
    this.HasSubminor = $Prm0.HasSubminor;
    this.Build = $Prm0.Build;
    this.HasBuild = $Prm0.HasBuild;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Major=" + Major // NOI18N
              + ", UsesUnderscores=" + UsesUnderscores // NOI18N
              + ", Minor=" + Minor // NOI18N
              + ", HasMinor=" + HasMinor // NOI18N
              + ", Subminor=" + Subminor // NOI18N
              + ", HasSubminor=" + HasSubminor // NOI18N
              + ", Build=" + Build // NOI18N
              + ", HasBuild=" + HasBuild; // NOI18N
  }
}
