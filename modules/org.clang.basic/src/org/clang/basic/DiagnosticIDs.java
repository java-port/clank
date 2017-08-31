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

import static org.clank.support.Native.$AddrOf;
import org.clang.basic.*;
import org.clang.basic.impl.DiagStatics;
import org.clang.basic.impl.DiagnosticIDsStatics;
import static org.clang.basic.impl.DiagnosticIDsStatics.*;
import org.clang.basic.impl.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;

/// \brief Used for handling and querying diagnostic IDs.
///
/// Can be used and shared by multiple Diagnostics for multiple translation units.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 116,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 116,
 FQN = "clang::DiagnosticIDs", NM = "_ZN5clang13DiagnosticIDsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDsE")
//</editor-fold>
public class DiagnosticIDs extends RefCountedBase<DiagnosticIDs> implements /*public*/ Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The level of the diagnostic, after it has been through mapping.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::Level">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 119,
   FQN = "clang::DiagnosticIDs::Level", NM = "_ZN5clang13DiagnosticIDs5LevelE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs5LevelE")
  //</editor-fold>
  public enum Level {
    Ignored(0),
    Note(Ignored.getValue() + 1),
    Remark(Note.getValue() + 1),
    Warning(Remark.getValue() + 1),
    Error(Warning.getValue() + 1),
    Fatal(Error.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Level valueOf(int val) {
      Level out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final Level[] VALUES;
      private static final Level[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Level kind : Level.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Level[min < 0 ? (1-min) : 0];
        VALUES = new Level[max >= 0 ? (1+max) : 0];
        for (Level kind : Level.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Level(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  }
/*private:*/
  /// \brief Information for uniquing and looking up custom diags.
  private DiagStatics.CustomDiagInfo /*P*/ CustomDiagInfo;
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Common Diagnostic implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::DiagnosticIDs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 299,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 303,
   FQN = "clang::DiagnosticIDs::DiagnosticIDs", NM = "_ZN5clang13DiagnosticIDsC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDsC1Ev")
  //</editor-fold>
  public DiagnosticIDs() {
    /* : RefCountedBase<DiagnosticIDs>()*/ 
    //START JInit
    super();
    //END JInit
    CustomDiagInfo = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::~DiagnosticIDs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 305,
   FQN = "clang::DiagnosticIDs::~DiagnosticIDs", NM = "_ZN5clang13DiagnosticIDsD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDsD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (CustomDiagInfo != null) { CustomDiagInfo.$destroy();};
  }

  @Override
  public String toString() {
    return "DiagnosticIDs{" + CustomDiagInfo + '}';
  } 
  
  // FIXME: Replace this function with a create-only facilty like
  // createCustomDiagIDFromFormatString() to enforce safe usage. At the time of
  // writing, nearly all callers of this function were invalid.

  /// getCustomDiagID - Return an ID for a diagnostic with the specified message
  /// and level.  If this is the first request for this diagnostic, it is
  /// registered and created, otherwise the existing ID is returned.
  ///
  /// \param FormatString A fixed diagnostic format string that will be hashed and
  /// mapped to a unique DiagID.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getCustomDiagID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 311,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 315,
   FQN = "clang::DiagnosticIDs::getCustomDiagID", NM = "_ZN5clang13DiagnosticIDs15getCustomDiagIDENS0_5LevelEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs15getCustomDiagIDENS0_5LevelEN4llvm9StringRefE")
  //</editor-fold>
  public /*uint*/int getCustomDiagID(Level L, StringRef FormatString) {
    if (!(CustomDiagInfo != null)) {
      CustomDiagInfo = new DiagStatics.CustomDiagInfo();
    }
    return CustomDiagInfo.getOrCreateDiagID(L, FormatString, /*Deref*/this);
  }

  
  /// \brief Given a diagnostic ID, return a description of the issue.

  /// getDescription - Given a diagnostic ID, return a description of the
  /// issue.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getDescription">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 363,
   FQN = "clang::DiagnosticIDs::getDescription", NM = "_ZNK5clang13DiagnosticIDs14getDescriptionEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs14getDescriptionEj")
  //</editor-fold>
  public StringRef getDescription(/*uint*/int DiagID) /*const*/ {
    {
      /*const*/ StaticDiagInfoRec /*P*/ Info = GetDiagInfo(DiagID);
      if ((Info != null)) {
        return Info.getDescription();
      }
    }
    assert ((CustomDiagInfo != null)) : "Invalid CustomDiagInfo";
    return CustomDiagInfo.getDescription(DiagID);
  }
  
  /// \brief Return true if the unmapped diagnostic levelof the specified
  /// diagnostic ID is a Warning or Extension.
  ///
  /// This only works on builtin diagnostics, not custom ones, and is not
  /// legal to call on NOTEs.
  
  /// isBuiltinWarningOrExtension - Return true if the unmapped diagnostic
  /// level of the specified diagnostic ID is a Warning or Extension.
  /// This only works on builtin diagnostics, not custom ones, and is not legal to
  /// call on NOTEs.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isBuiltinWarningOrExtension">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 326,
   FQN = "clang::DiagnosticIDs::isBuiltinWarningOrExtension", NM = "_ZN5clang13DiagnosticIDs27isBuiltinWarningOrExtensionEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs27isBuiltinWarningOrExtensionEj")
  //</editor-fold>
  public static boolean isBuiltinWarningOrExtension(/*uint*/int DiagID) {
    return DiagID < diag.DIAG_UPPER_LIMIT && getBuiltinDiagClass(DiagID) != CLASS_ERROR;
  }

  
/// \brief Return true if the specified diagnostic is mapped to errors by
/// default.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isDefaultMappingAsError">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 350,
 FQN="clang::DiagnosticIDs::isDefaultMappingAsError", NM="_ZN5clang13DiagnosticIDs23isDefaultMappingAsErrorEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs23isDefaultMappingAsErrorEj")
//</editor-fold>
public static boolean isDefaultMappingAsError(/*uint*/int DiagID) {
  if ($greatereq_uint(DiagID, diag.DIAG_UPPER_LIMIT)) {
    return false;
  }
  
  return GetDefaultDiagMapping(DiagID).getSeverity().getValue() >= diag.Severity.Error.getValue();
}

  
  /// \brief Determine whether the given built-in diagnostic ID is a Note.
  
  /// \brief Determine whether the given built-in diagnostic ID is a
  /// Note.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isBuiltinNote">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 329,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 333,
   FQN = "clang::DiagnosticIDs::isBuiltinNote", NM = "_ZN5clang13DiagnosticIDs13isBuiltinNoteEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs13isBuiltinNoteEj")
  //</editor-fold>
  public static boolean isBuiltinNote(/*uint*/int DiagID) {
    return DiagID < diag.DIAG_UPPER_LIMIT && getBuiltinDiagClass(DiagID) == CLASS_NOTE;
  }
  
  /// \brief Determine whether the given built-in diagnostic ID is for an
  /// extension of some sort.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isBuiltinExtensionDiag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 165,
   FQN="clang::DiagnosticIDs::isBuiltinExtensionDiag", NM="_ZN5clang13DiagnosticIDs22isBuiltinExtensionDiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs22isBuiltinExtensionDiagEj")
  //</editor-fold>
  public static boolean isBuiltinExtensionDiag(/*uint*/int DiagID) {
    bool$ref ignored = create_bool$ref();
    return isBuiltinExtensionDiag(DiagID, ignored);
  }

  /// \brief Determine whether the given built-in diagnostic ID is for an
  /// extension of some sort, and whether it is enabled by default.
  ///
  /// This also returns EnabledByDefault, which is set to indicate whether the
  /// diagnostic is ignored by default (in which case -pedantic enables it) or
  /// treated as a warning/error by default.
  ///
  /// isBuiltinExtensionDiag - Determine whether the given built-in diagnostic
  /// ID is for an extension of some sort.  This also returns EnabledByDefault,
  /// which is set to indicate whether the diagnostic is ignored by default (in
  /// which case -pedantic enables it) or treated as a warning/error by default.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isBuiltinExtensionDiag">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 339,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 343,
     FQN = "clang::DiagnosticIDs::isBuiltinExtensionDiag", NM = "_ZN5clang13DiagnosticIDs22isBuiltinExtensionDiagEjRb",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs22isBuiltinExtensionDiagEjRb")
  //</editor-fold>
  public static boolean isBuiltinExtensionDiag(/*uint*/int DiagID,
          bool$ref/*bool &*/ EnabledByDefault) {
    if (DiagID >= diag.DIAG_UPPER_LIMIT
            || getBuiltinDiagClass(DiagID) != CLASS_EXTENSION) {
      return false;
    }

    EnabledByDefault.$set(GetDefaultDiagMapping(DiagID).getSeverity() != diag.Severity.Ignored);
    return true;
  }

  
  /// \brief Return the lowest-level warning option that enables the specified
  /// diagnostic.
  ///
  /// If there is no -Wfoo flag that controls the diagnostic, this returns null.

  /// getWarningOptionForDiag - Return the lowest-level warning option that
  /// enables the specified diagnostic.  If there is no -Wfoo flag that controls
  /// the diagnostic, this returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getWarningOptionForDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 514,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 508,
   FQN="clang::DiagnosticIDs::getWarningOptionForDiag", NM="_ZN5clang13DiagnosticIDs23getWarningOptionForDiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs23getWarningOptionForDiagEj")
  //</editor-fold>
  public static StringRef getWarningOptionForDiag(/*uint*/int DiagID) {
    {
      /*const*/ StaticDiagInfoRec /*P*/ Info = GetDiagInfo(DiagID);
      if ((Info != null)) {
        return OptionTable[(int)Info.getOptionGroupIndex()].getName();
      }
    }
    return new StringRef();
  }
  
  /// \brief Return the category number that a specified \p DiagID belongs to,
  /// or 0 if no category.
  
  /// getCategoryNumberForDiag - Return the category number that a specified
  /// DiagID belongs to, or 0 if no category.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getCategoryNumberForDiag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*uchar2uint*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 176,
   FQN="clang::DiagnosticIDs::getCategoryNumberForDiag", NM="_ZN5clang13DiagnosticIDs24getCategoryNumberForDiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs24getCategoryNumberForDiagEj")
  //</editor-fold>
  public static /*uint*/int getCategoryNumberForDiag(/*uint*/int DiagID) {
    {
      /*const*/StaticDiagInfoRec /*P*/ Info = GetDiagInfo(DiagID);
      if ((Info != null)) {
        return $uchar2uint(Info.Category);
      }
    }
    return 0;
  }

  
  /// \brief Return the number of diagnostic categories.
  
  /// getNumberOfCategories - Return the number of categories
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getNumberOfCategories">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 218,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 222,
   FQN = "clang::DiagnosticIDs::getNumberOfCategories", NM = "_ZN5clang13DiagnosticIDs21getNumberOfCategoriesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs21getNumberOfCategoriesEv")
  //</editor-fold>
  public static /*uint*/int getNumberOfCategories() {
    return llvm.array_lengthof(CategoryNameTable) - 1;
  }

  
  /// \brief Given a category ID, return the name of the category.
  
  /// getCategoryNameFromID - Given a category ID, return the name of the
  /// category, an empty string if CategoryID is zero, or null if CategoryID is
  /// invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getCategoryNameFromID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 229,
   FQN = "clang::DiagnosticIDs::getCategoryNameFromID", NM = "_ZN5clang13DiagnosticIDs21getCategoryNameFromIDEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs21getCategoryNameFromIDEj")
  //</editor-fold>
  public static StringRef getCategoryNameFromID(/*uint*/int CategoryID) {
    if (CategoryID >= getNumberOfCategories()) {
      return new StringRef();
    }
    return CategoryNameTable[(int) CategoryID].getName();
  }

  
  /// \brief Return true if a given diagnostic falls into an ARC diagnostic
  /// category.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isARCDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 716,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 710,
   FQN="clang::DiagnosticIDs::isARCDiagnostic", NM="_ZN5clang13DiagnosticIDs15isARCDiagnosticEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs15isARCDiagnosticEj")
  //</editor-fold>
  public static boolean isARCDiagnostic(/*uint*/int DiagID) {
    /*uint*/int cat = getCategoryNumberForDiag(DiagID);
    return DiagnosticIDs.getCategoryNameFromID(cat).startswith("ARC ");
  }

  
  /// \brief Enumeration describing how the emission of a diagnostic should
  /// be treated when it occurs during C++ template argument deduction.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::SFINAEResponse">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticIDs.h", old_line = 202,
   FQN = "clang::DiagnosticIDs::SFINAEResponse", NM = "_ZN5clang13DiagnosticIDs14SFINAEResponseE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs14SFINAEResponseE")
  //</editor-fold>
  public enum SFINAEResponse {
    /// \brief The diagnostic should not be reported, but it should cause
    /// template argument deduction to fail.
    ///
    /// The vast majority of errors that occur during template argument 
    /// deduction fall into this category.
    SFINAE_SubstitutionFailure(0),
    
    /// \brief The diagnostic should be suppressed entirely.
    ///
    /// Warnings generally fall into this category.
    SFINAE_Suppress(1),
    
    /// \brief The diagnostic should be reported.
    ///
    /// The diagnostic should be reported. Various fatal errors (e.g., 
    /// template instantiation depth exceeded) fall into this category.
    SFINAE_Report(2),
    
    /// \brief The diagnostic is an access-control diagnostic, which will be
    /// substitution failures in some contexts and reported in others.
    SFINAE_AccessControl(3);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SFINAEResponse valueOf(int val) {
      SFINAEResponse out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final SFINAEResponse[] VALUES;
      private static final SFINAEResponse[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SFINAEResponse kind : SFINAEResponse.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SFINAEResponse[min < 0 ? (1-min) : 0];
        VALUES = new SFINAEResponse[max >= 0 ? (1+max) : 0];
        for (SFINAEResponse kind : SFINAEResponse.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SFINAEResponse(int val) { this.value = (/*uint*/int)val;}
    public int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Determines whether the given built-in diagnostic ID is
  /// for an error that is suppressed if it occurs during C++ template
  /// argument deduction.
  ///
  /// When an error is suppressed due to SFINAE, the template argument
  /// deduction fails but no diagnostic is emitted. Certain classes of
  /// errors, such as those errors that involve C++ access control,
  /// are not SFINAE errors.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getDiagnosticSFINAEResponse">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 237,
   FQN = "clang::DiagnosticIDs::getDiagnosticSFINAEResponse", NM = "_ZN5clang13DiagnosticIDs27getDiagnosticSFINAEResponseEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs27getDiagnosticSFINAEResponseEj")
  //</editor-fold>
  public static DiagnosticIDs.SFINAEResponse getDiagnosticSFINAEResponse(/*uint*/int DiagID) {
    {
      /*const*/StaticDiagInfoRec /*P*/ Info = GetDiagInfo(DiagID);
      if ((Info != null)) {
        return Info.SFINAE;
      }
    }
    return SFINAEResponse.SFINAE_Report;
  }

  
/// \brief Get the set of all diagnostic IDs in the group with the given name.
///
/// \param[out] Diags - On return, the diagnostics in the group.
/// \returns \c true if the given group is unknown, \c false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getDiagnosticsInGroup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 550,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 544,
 FQN="clang::DiagnosticIDs::getDiagnosticsInGroup", NM="_ZNK5clang13DiagnosticIDs21getDiagnosticsInGroupENS_4diag6FlavorEN4llvm9StringRefERNS3_15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs21getDiagnosticsInGroupENS_4diag6FlavorEN4llvm9StringRefERNS3_15SmallVectorImplIjEE")
//</editor-fold>
public boolean getDiagnosticsInGroup(diag.Flavor Flavor, StringRef Group, 
                     SmallVectorImplUInt/*<diag.kind>*//*&*/ Diags) /*const*/ {
  /*const*/ type$ptr<WarningOption> /*P*/ Found = std.lower_bound(std.begin(OptionTable), std.end(OptionTable), Group, 
       (WarningOption LHS, StringRef RHS) -> 
        {
          return $less_StringRef(((WarningOption) LHS).getName(), RHS);
        }
    );
  if (Found.$eq(std.end(OptionTable)) || $noteq_StringRef(Found.$star().getName(), Group)) {
    return true; // Option not found.
  }
  
  return /*::*/DiagnosticIDsStatics.getDiagnosticsInGroup(Flavor, Found.$star(), Diags);
}

  
  /// \brief Get the set of all diagnostic IDs.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getAllDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 564,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 558,
   FQN="clang::DiagnosticIDs::getAllDiagnostics", NM="_ZNK5clang13DiagnosticIDs17getAllDiagnosticsENS_4diag6FlavorERN4llvm15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs17getAllDiagnosticsENS_4diag6FlavorERN4llvm15SmallVectorImplIjEE")
  //</editor-fold>
  public void getAllDiagnostics(diag.Flavor Flavor, 
                   SmallVectorImplUInt/*<diag.kind>*//*&*/ Diags) /*const*/ {
    for (/*uint*/int i = 0; i != StaticDiagInfoSize; ++i)  {
      if (StaticDiagInfo[(int)i].getFlavor() == Flavor) {
        Diags.push_back(StaticDiagInfo[(int)i].DiagID);
      }
    }
  }

  /// \brief Get the diagnostic option with the closest edit distance to the
  /// given group name.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getNearestOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 571,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 565,
   FQN="clang::DiagnosticIDs::getNearestOption", NM="_ZN5clang13DiagnosticIDs16getNearestOptionENS_4diag6FlavorEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang13DiagnosticIDs16getNearestOptionENS_4diag6FlavorEN4llvm9StringRefE")
  //</editor-fold>
  public static StringRef getNearestOption(diag.Flavor Flavor, 
                  StringRef Group) {
    StringRef Best/*J*/= new StringRef();
    /*uint*/int BestDistance = Group.size() + 1; // Sanity threshold.
    for (/*const*/ WarningOption /*&*/ O : OptionTable) {
      SmallVectorUInt/*diag.kind*/ Diags = null;
      try {
        // Don't suggest ignored warning flags.
        if (!(O.Members != 0) && !(O.SubGroups != 0)) {
          continue;
        }

        /*uint*/int Distance = O.getName().edit_distance(Group, true, BestDistance);
        if (Distance > BestDistance) {
          continue;
        }

        // Don't suggest groups that are not of this kind.
        Diags/*J*/= new SmallVectorUInt/*diag.kind*/(8, 0);
        if (/*::*/DiagnosticIDsStatics.getDiagnosticsInGroup(Flavor, O, Diags) || Diags.empty()) {
          continue;
        }
        if (Distance == BestDistance) {
          // Two matches with the same distance, don't prefer one over the other.
          Best.$assign($(""));
        } else if (Distance < BestDistance) {
          // This is a better match.
          Best.$assign(O.getName());
          BestDistance = Distance;
        }
      } finally {
        if (Diags != null) { Diags.$destroy(); }
      }
    }

    return Best;
  }


/*private:*/
  /// \brief Classify the specified diagnostic ID into a Level, consumable by
  /// the DiagnosticClient.
  /// 
  /// The classification is based on the way the client configured the
  /// DiagnosticsEngine object.
  ///
  /// \param Loc The source location for which we are interested in finding out
  /// the diagnostic state. Can be null in order to query the latest state.

  /// getDiagnosticLevel - Based on the way the client configured the
  /// DiagnosticsEngine object, classify the specified diagnostic ID into a Level,
  /// by consumable the DiagnosticClient.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getDiagnosticLevel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 385,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 389,
   FQN = "clang::DiagnosticIDs::getDiagnosticLevel", NM = "_ZNK5clang13DiagnosticIDs18getDiagnosticLevelEjNS_14SourceLocationERKNS_17DiagnosticsEngineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs18getDiagnosticLevelEjNS_14SourceLocationERKNS_17DiagnosticsEngineE")
  //</editor-fold>
  /*friend*//*private*/ DiagnosticIDs.Level getDiagnosticLevel(/*uint*/int DiagID, SourceLocation Loc, 
                    /*const*/ DiagnosticsEngine /*&*/ Diag) /*const*//* __attribute__((pure))*/ {
    // Handle custom diagnostics, which cannot be mapped.
    if (DiagID >= diag.DIAG_UPPER_LIMIT) {
      assert ((CustomDiagInfo != null)) : "Invalid CustomDiagInfo";
      return CustomDiagInfo.getLevel(DiagID);
    }

    /*uint*/int DiagClass = getBuiltinDiagClass(DiagID);
    if (DiagClass == CLASS_NOTE) {
      return DiagnosticIDs.Level.Note;
    }
    return toLevel(getDiagnosticSeverity(DiagID, Loc, Diag));
  }

  /// \brief Based on the way the client configured the Diagnostic
  /// object, classify the specified diagnostic ID into a Level, consumable by
  /// the DiagnosticClient.
  ///
  /// \param Loc The source location we are interested in finding out the
  /// diagnostic state. Can be null in order to query the latest state.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::getDiagnosticSeverity">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 405,
   FQN="clang::DiagnosticIDs::getDiagnosticSeverity", NM="_ZNK5clang13DiagnosticIDs21getDiagnosticSeverityEjNS_14SourceLocationERKNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs21getDiagnosticSeverityEjNS_14SourceLocationERKNS_17DiagnosticsEngineE")
  //</editor-fold>
  /*friend*//*private*/ diag.Severity getDiagnosticSeverity(/*uint*/int DiagID, SourceLocation Loc, 
                       /*const*/ DiagnosticsEngine /*&*/ Diag) /*const*//* __attribute__((pure))*/ {
    assert (getBuiltinDiagClass(DiagID) != CLASS_NOTE);
    
    // Specific non-error diagnostics may be mapped to various levels from ignored
    // to error.  Errors can only be mapped to fatal.
    diag.Severity Result = diag.Severity.Fatal;
    
    DiagnosticsEngine.DiagStatePoint Pos = Diag.GetDiagStatePointForLoc(Loc);
    DiagnosticsEngine.DiagState /*P*/ State = Pos.State;
    
    // Get the mapping information, or compute it lazily.
    DiagnosticMapping /*&*/ Mapping = State.getOrAddMapping((/*diag::kind*/int)DiagID);
    
    // TODO: Can a null severity really get here?
    if (Mapping.getSeverity() != diag.Severity.Uncomputed) {
      Result = Mapping.getSeverity();
    }
    
    // Upgrade ignored diagnostics if -Weverything is enabled.
    if (Diag.EnableAllWarnings && Result == diag.Severity.Ignored
       && !Mapping.isUser() && getBuiltinDiagClass(DiagID) != CLASS_REMARK) {
      Result = diag.Severity.Warning;
    }
    
    // Ignore -pedantic diagnostics inside __extension__ blocks.
    // (The diagnostics controlled by -pedantic are the extension diagnostics
    // that are not enabled by default.)
    bool$ref EnabledByDefault = create_bool$ref(false);
    boolean IsExtensionDiag = isBuiltinExtensionDiag(DiagID, EnabledByDefault);
    if ((Diag.AllExtensionsSilenced != 0) && IsExtensionDiag && !EnabledByDefault.$deref()) {
      return diag.Severity.Ignored;
    }
    
    // For extension diagnostics that haven't been explicitly mapped, check if we
    // should upgrade the diagnostic.
    if (IsExtensionDiag && !Mapping.isUser()) {
      Result = std.max(Result, Diag.ExtBehavior);
    }
    
    // At this point, ignored errors can no longer be upgraded.
    if (Result == diag.Severity.Ignored) {
      return Result;
    }
    
    // Honor -w, which is lower in priority than pedantic-errors, but higher than
    // -Werror.
    if (Result == diag.Severity.Warning && Diag.IgnoreAllWarnings) {
      return diag.Severity.Ignored;
    }
    
    // If -Werror is enabled, map warnings to errors unless explicitly disabled.
    if (Result == diag.Severity.Warning) {
      if (Diag.WarningsAsErrors && !Mapping.hasNoWarningAsError()) {
        Result = diag.Severity.Error;
      }
    }
    
    // If -Wfatal-errors is enabled, map errors to fatal unless explicity
    // disabled.
    if (Result == diag.Severity.Error) {
      if (Diag.ErrorsAsFatal && !Mapping.hasNoErrorAsFatal()) {
        Result = diag.Severity.Fatal;
      }
    }
    
    // If explicitly requested, map fatal errors to errors.
    if (Result == diag.Severity.Fatal) {
      if (Diag.FatalsAsError) {
        Result = diag.Severity.Error;
      }
    }
    
    // Custom diagnostics always are emitted in system headers.
    boolean ShowInSystemHeader = !(GetDiagInfo(DiagID) != null) || GetDiagInfo(DiagID).WarnShowInSystemHeader;
    
    // If we are in a system header, we ignore it. We look at the diagnostic class
    // because we also want to ignore extensions and warnings in -Werror and
    // -pedantic-errors modes, which *map* warnings/extensions to errors.
    if (Diag.SuppressSystemWarnings && !ShowInSystemHeader && Loc.isValid()
       && Diag.getSourceManager().isInSystemHeader(Diag.getSourceManager().getExpansionLoc(/*NO_COPY*/Loc))) {
      return diag.Severity.Ignored;
    }
    
    return Result;
  }
  
  /// \brief Used to report a diagnostic that is finally fully formed.
  ///
  /// \returns \c true if the diagnostic was emitted, \c false if it was
  /// suppressed.

  /// ProcessDiag - This is the method used to report a diagnostic that is
  /// finally fully formed.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::ProcessDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 604,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 598,
   FQN="clang::DiagnosticIDs::ProcessDiag", NM="_ZNK5clang13DiagnosticIDs11ProcessDiagERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs11ProcessDiagERNS_17DiagnosticsEngineE")
  //</editor-fold>
   boolean ProcessDiag(DiagnosticsEngine /*&*/ Diag) /*const*/ {
    Diagnostic Info/*J*/= new Diagnostic($AddrOf(Diag));
    assert ((Diag.getClient() != null)) : "DiagnosticClient not set!";

    // Figure out the diagnostic level of this message.
    /*uint*/int DiagID = Info.getID();
    DiagnosticIDs.Level DiagLevel = getDiagnosticLevel(DiagID, Info.getLocation(), Diag);

    // Update counts for DiagnosticErrorTrap even if a fatal error occurred
    // or diagnostics are suppressed.
    if (DiagLevel.getValue() >= DiagnosticIDs.Level.Error.getValue()) {
      ++Diag.TrapNumErrorsOccurred;
      if (isUnrecoverable(DiagID)) {
        ++Diag.TrapNumUnrecoverableErrorsOccurred;
      }
    }
    if (Diag.SuppressAllDiagnostics) {
      return false;
    }
    if (DiagLevel != DiagnosticIDs.Level.Note) {
      // Record that a fatal error occurred only when we see a second
      // non-note diagnostic. This allows notes to be attached to the
      // fatal error, but suppresses any diagnostics that follow those
      // notes.
      if (Diag.LastDiagLevel == DiagnosticIDs.Level.Fatal) {
        Diag.FatalErrorOccurred = true;
      }

      Diag.LastDiagLevel = DiagLevel;
    }

    // If a fatal error has already been emitted, silence all subsequent
    // diagnostics.
    if (Diag.FatalErrorOccurred) {
      if (DiagLevel.getValue() >= DiagnosticIDs.Level.Error.getValue()
         && Diag.Client.IncludeInDiagnosticCounts()) {
        ++Diag.NumErrors;
      }

      return false;
    }

    // If the client doesn't care about this message, don't issue it.  If this is
    // a note and the last real diagnostic was ignored, ignore it too.
    if (DiagLevel == DiagnosticIDs.Level.Ignored
       || (DiagLevel == DiagnosticIDs.Level.Note
       && Diag.LastDiagLevel == DiagnosticIDs.Level.Ignored)) {
      return false;
    }
    if (DiagLevel.getValue() >= DiagnosticIDs.Level.Error.getValue()) {
      if (isUnrecoverable(DiagID)) {
        Diag.UnrecoverableErrorOccurred = true;
      }

      // Warnings which have been upgraded to errors do not prevent compilation.
      if (isDefaultMappingAsError(DiagID)) {
        Diag.UncompilableErrorOccurred = true;
      }

      Diag.ErrorOccurred = true;
      if (Diag.Client.IncludeInDiagnosticCounts()) {
        ++Diag.NumErrors;
      }

      // If we've emitted a lot of errors, emit a fatal error instead of it to 
      // stop a flood of bogus errors.
      if ((Diag.ErrorLimit != 0) && Diag.NumErrors > Diag.ErrorLimit
         && DiagLevel == DiagnosticIDs.Level.Error) {
        Diag.SetDelayedDiagnostic(diag.fatal_too_many_errors);
        return false;
      }
    }

    // Finally, report it.
    EmitDiag(Diag, DiagLevel);
    return true;
  }

  
  /// \brief Used to emit a diagnostic that is finally fully formed,
  /// ignoring suppression.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::EmitDiag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear stack used by debug*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 681,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 675,
   FQN="clang::DiagnosticIDs::EmitDiag", NM="_ZNK5clang13DiagnosticIDs8EmitDiagERNS_17DiagnosticsEngineENS0_5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs8EmitDiagERNS_17DiagnosticsEngineENS0_5LevelE")
  //</editor-fold>
  /*friend*/ void EmitDiag(DiagnosticsEngine /*&*/ Diag, Level DiagLevel) /*const*/ {
    Diagnostic Info/*J*/= new Diagnostic($AddrOf(Diag));
    assert (DiagLevel != DiagnosticIDs.Level.Ignored) : "Cannot emit ignored diagnostics!";
    
    Diag.Client.HandleDiagnostic(DiagnosticsEngine.Level.valueOf(DiagLevel.getValue()), Info);
    if (Diag.Client.IncludeInDiagnosticCounts()) {
      if (DiagLevel == DiagnosticIDs.Level.Warning) {
        ++Diag.NumWarnings;
      }
    }
    
    Diag.CurDiagID = ~0/*U*/;
    assert Diag.clearDiagnosticsReportStack();
  }

  
  /// \brief Whether the diagnostic may leave the AST in a state where some
  /// invariants can break.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticIDs::isUnrecoverable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 694,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 688,
   FQN="clang::DiagnosticIDs::isUnrecoverable", NM="_ZNK5clang13DiagnosticIDs15isUnrecoverableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang13DiagnosticIDs15isUnrecoverableEj")
  //</editor-fold>
  private boolean isUnrecoverable(/*uint*/int DiagID) /*const*/ {
    if (DiagID >= diag.DIAG_UPPER_LIMIT) {
      assert ((CustomDiagInfo != null)) : "Invalid CustomDiagInfo";
      // Custom diagnostics.
      return CustomDiagInfo.getLevel(DiagID).getValue() >= DiagnosticIDs.Level.Error.getValue();
    }

    // Only errors may be unrecoverable.
    if (getBuiltinDiagClass(DiagID) < CLASS_ERROR) {
      return false;
    }
    if (DiagID == diag.err_unavailable
       || DiagID == diag.err_unavailable_message) {
      return false;
    }

    // Currently we consider all ARC errors as recoverable.
    if (isARCDiagnostic((int) DiagID)) {
      return false;
    }

    return true;
  }
}