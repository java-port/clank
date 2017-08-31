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

package org.clang.lex;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativeType.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief The preprocessor keeps track of this information for each
/// file that is \#included.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*POD*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 39,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 38,
 FQN="clang::HeaderFileInfo", NM="_ZN5clang14HeaderFileInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang14HeaderFileInfoE")
//</editor-fold>
public class/*struct*/ HeaderFileInfo implements Native.NativePOD<HeaderFileInfo>, SizeofCapable {
  public static final HeaderFileInfo DEFAULT = new HeaderFileInfo();
  
  /// \brief True if this is a \#import'd or \#pragma once file.
  public /*JBIT unsigned int*/ boolean isImport /*: 1*/;
  
  /// \brief True if this is a \#pragma once file.
  public /*JBIT unsigned int*/ boolean isPragmaOnce /*: 1*/;
  
  /// DirInfo - Keep track of whether this is a system header, and if so,
  /// whether it is C++ clean or not.  This can be set by the include paths or
  /// by \#pragma gcc system_header.  This is an instance of
  /// SrcMgr::CharacteristicKind.
  public /*JBYTE unsigned int*/ byte DirInfo /*: 2*/;
  
  /// \brief Whether this header file info was supplied by an external source,
  /// and has not changed since.
  public /*JBIT unsigned int*/ boolean External /*: 1*/;
  
  /// \brief Whether this header is part of a module.
  public /*JBIT unsigned int*/ boolean isModuleHeader /*: 1*/;
  
  /// \brief Whether this header is part of the module that we are building.
  public /*JBIT unsigned int*/ boolean isCompilingModuleHeader /*: 1*/;
  
  /// \brief Whether this structure is considered to already have been
  /// "resolved", meaning that it was loaded from the external source.
  public /*JBIT unsigned int*/ boolean Resolved /*: 1*/;
  
  /// \brief Whether this is a header inside a framework that is currently
  /// being built. 
  ///
  /// When a framework is being built, the headers have not yet been placed
  /// into the appropriate framework subdirectories, and therefore are
  /// provided via a header map. This bit indicates when this is one of
  /// those framework headers.
  public /*JBIT unsigned int*/ boolean IndexHeaderMapHeader /*: 1*/;
  
  /// \brief Whether this file has been looked up as a header.
  public /*JBIT unsigned int*/ boolean IsValid /*: 1*/;
  
  /// \brief The number of times the file has been included already.
  public /*ushort*/char NumIncludes;
  
  /// \brief The ID number of the controlling macro.
  ///
  /// This ID number will be non-zero when there is a controlling
  /// macro whose IdentifierInfo may not yet have been loaded from
  /// external storage.
  public /*uint*/int ControllingMacroID;
  
  /// If this file has a \#ifndef XXX (or equivalent) guard that
  /// protects the entire contents of the file, this is the identifier
  /// for the macro that controls whether or not it has any effect.
  ///
  /// Note: Most clients should use getControllingMacro() to access
  /// the controlling macro of this header, since
  /// getControllingMacro() is able to load a controlling macro from
  /// external storage.
  public /*const*/ IdentifierInfo /*P*/ ControllingMacro;
  
  /// \brief If this header came from a framework include, this is the name
  /// of the framework.
  public StringRef Framework;
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::HeaderFileInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 104,
   FQN="clang::HeaderFileInfo::HeaderFileInfo", NM="_ZN5clang14HeaderFileInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang14HeaderFileInfoC1Ev")
  //</editor-fold>
  public HeaderFileInfo() {
    /* : isImport(false), isPragmaOnce(false), DirInfo(SrcMgr::C_User), External(false), isModuleHeader(false), isCompilingModuleHeader(false), Resolved(false), IndexHeaderMapHeader(false), IsValid(0), NumIncludes(0), ControllingMacroID(0), ControllingMacro(null), Framework()*/ 
    //START JInit
    clear();
    //END JInit
  }

  
  /// \brief Retrieve the controlling macro for this header file, if
  /// any.
  
  /// \brief Retrieve the controlling macro for this header file, if
  /// any.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::getControllingMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 37,
   FQN="clang::HeaderFileInfo::getControllingMacro", NM="_ZN5clang14HeaderFileInfo19getControllingMacroEPNS_26ExternalPreprocessorSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang14HeaderFileInfo19getControllingMacroEPNS_26ExternalPreprocessorSourceE")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getControllingMacro(ExternalPreprocessorSource /*P*/ External) {
    if ((ControllingMacro != null)) {
      if (ControllingMacro.isOutOfDate()) {
        External.updateOutOfDateIdentifier($Deref(((/*const_cast*/IdentifierInfo /*P*/ )(ControllingMacro))));
      }
      return ControllingMacro;
    }
    if (!(ControllingMacroID != 0) || !(External != null)) {
      return null;
    }
    
    ControllingMacro = External.GetIdentifier(ControllingMacroID);
    return ControllingMacro;
  }


  
  /// \brief Determine whether this is a non-default header file info, e.g.,
  /// it corresponds to an actual header we've included or tried to include.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::isNonDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 117,
   FQN="clang::HeaderFileInfo::isNonDefault", NM="_ZNK5clang14HeaderFileInfo12isNonDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang14HeaderFileInfo12isNonDefaultEv")
  //</editor-fold>
  public boolean isNonDefault() /*const*/ {
    return isImport || isPragmaOnce || (NumIncludes != 0) || (ControllingMacro != null)
       || (ControllingMacroID != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::HeaderFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 38,
   FQN="clang::HeaderFileInfo::HeaderFileInfo", NM="_ZN5clang14HeaderFileInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang14HeaderFileInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ HeaderFileInfo(/*const*/ HeaderFileInfo /*&*/ $Prm0) {
    /* : isImport(.isImport), isPragmaOnce(.isPragmaOnce), DirInfo(.DirInfo), External(.External), isModuleHeader(.isModuleHeader), isCompilingModuleHeader(.isCompilingModuleHeader), Resolved(.Resolved), IndexHeaderMapHeader(.IndexHeaderMapHeader), IsValid(.IsValid), NumIncludes(.NumIncludes), ControllingMacroID(.ControllingMacroID), ControllingMacro(.ControllingMacro), Framework(.Framework)*/ 
    //START JInit
    this.isImport = $Prm0.isImport;
    this.isPragmaOnce = $Prm0.isPragmaOnce;
    this.DirInfo = $Prm0.DirInfo;
    this.External = $Prm0.External;
    this.isModuleHeader = $Prm0.isModuleHeader;
    this.isCompilingModuleHeader = $Prm0.isCompilingModuleHeader;
    this.Resolved = $Prm0.Resolved;
    this.IndexHeaderMapHeader = $Prm0.IndexHeaderMapHeader;
    this.IsValid = $Prm0.IsValid;
    this.NumIncludes = $Prm0.NumIncludes;
    this.ControllingMacroID = $Prm0.ControllingMacroID;
    this.ControllingMacro = $Prm0.ControllingMacro;
    this.Framework = new StringRef($Prm0.Framework);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::HeaderFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 38,
   FQN="clang::HeaderFileInfo::HeaderFileInfo", NM="_ZN5clang14HeaderFileInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang14HeaderFileInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ HeaderFileInfo(JD$Move _dparam, HeaderFileInfo /*&&*/$Prm0) {
    /* : isImport(static_cast<HeaderFileInfo &&>().isImport), isPragmaOnce(static_cast<HeaderFileInfo &&>().isPragmaOnce), DirInfo(static_cast<HeaderFileInfo &&>().DirInfo), External(static_cast<HeaderFileInfo &&>().External), isModuleHeader(static_cast<HeaderFileInfo &&>().isModuleHeader), isCompilingModuleHeader(static_cast<HeaderFileInfo &&>().isCompilingModuleHeader), Resolved(static_cast<HeaderFileInfo &&>().Resolved), IndexHeaderMapHeader(static_cast<HeaderFileInfo &&>().IndexHeaderMapHeader), IsValid(static_cast<HeaderFileInfo &&>().IsValid), NumIncludes(static_cast<HeaderFileInfo &&>().NumIncludes), ControllingMacroID(static_cast<HeaderFileInfo &&>().ControllingMacroID), ControllingMacro(static_cast<HeaderFileInfo &&>().ControllingMacro), Framework(static_cast<HeaderFileInfo &&>().Framework)*/ 
    //START JInit
    this.isImport = $Prm0.isImport;
    this.isPragmaOnce = $Prm0.isPragmaOnce;
    this.DirInfo = $Prm0.DirInfo;
    this.External = $Prm0.External;
    this.isModuleHeader = $Prm0.isModuleHeader;
    this.isCompilingModuleHeader = $Prm0.isCompilingModuleHeader;
    this.Resolved = $Prm0.Resolved;
    this.IndexHeaderMapHeader = $Prm0.IndexHeaderMapHeader;
    this.IsValid = $Prm0.IsValid;
    this.NumIncludes = $Prm0.NumIncludes;
    this.ControllingMacroID = $Prm0.ControllingMacroID;
    this.ControllingMacro = $Prm0.ControllingMacro;
    this.Framework = $Prm0.Framework;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 38,
   FQN="clang::HeaderFileInfo::operator=", NM="_ZN5clang14HeaderFileInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang14HeaderFileInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ HeaderFileInfo /*&*/ $assignMove(HeaderFileInfo /*&&*/$Prm0) {
    this.isImport = $Prm0.isImport;
    this.isPragmaOnce = $Prm0.isPragmaOnce;
    this.DirInfo = $Prm0.DirInfo;
    this.External = $Prm0.External;
    this.isModuleHeader = $Prm0.isModuleHeader;
    this.isCompilingModuleHeader = $Prm0.isCompilingModuleHeader;
    this.Resolved = $Prm0.Resolved;
    this.IndexHeaderMapHeader = $Prm0.IndexHeaderMapHeader;
    this.IsValid = $Prm0.IsValid;
    this.NumIncludes = $Prm0.NumIncludes;
    this.ControllingMacroID = $Prm0.ControllingMacroID;
    this.ControllingMacro = $Prm0.ControllingMacro;
    this.Framework.$assignMove($Prm0.Framework);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "HeaderFileInfo{" + "isImport=" + isImport // NOI18N
              + ", isPragmaOnce=" + isPragmaOnce // NOI18N
              + ", DirInfo=" + DirInfo // NOI18N
              + ", External=" + External // NOI18N
              + ", isModuleHeader=" + isModuleHeader // NOI18N
              + ", isCompilingModuleHeader=" + isCompilingModuleHeader // NOI18N
              + ", Resolved=" + Resolved // NOI18N
              + ", IndexHeaderMapHeader=" + IndexHeaderMapHeader // NOI18N
              + ", IsValid=" + IsValid // NOI18N
              + ", NumIncludes=" + NumIncludes // NOI18N
              + ", ControllingMacroID=" + ControllingMacroID // NOI18N
              + ", ControllingMacro=" + ControllingMacro // NOI18N
              + ", Framework=" + Framework + '}'; // NOI18N
  }
  
  @Override
  public HeaderFileInfo $assign(HeaderFileInfo value) {
    return $assignMove(value);
  }
  
  @Override
  public HeaderFileInfo clone() {
    return new HeaderFileInfo(this);
  }

  @Override
  public boolean $noteq(HeaderFileInfo other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(HeaderFileInfo other) {
    if (this.isImport != other.isImport) {
      return false;
    }
    if (this.isPragmaOnce != other.isPragmaOnce) {
      return false;
    }
    if (this.DirInfo != other.DirInfo) {
      return false;
    }
    if (this.External != other.External) {
      return false;
    }
    if (this.isModuleHeader != other.isModuleHeader) {
      return false;
    }
    if (this.isCompilingModuleHeader != other.isCompilingModuleHeader) {
      return false;
    }
    if (this.Resolved != other.Resolved) {
      return false;
    }
    if (this.IndexHeaderMapHeader != other.IndexHeaderMapHeader) {
      return false;
    }
    if (this.NumIncludes != other.NumIncludes) {
      return false;
    }
    if (this.ControllingMacroID != other.ControllingMacroID) {
      return false;
    }
    if (this.ControllingMacro != other.ControllingMacro && (this.ControllingMacro == null || !this.ControllingMacro.equals(other.ControllingMacro))) {
      return false;
    }
    if (this.Framework != other.Framework && (this.Framework == null || !this.Framework.equals(other.Framework))) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderFileInfo::~HeaderFileInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 38,
   FQN = "clang::HeaderFileInfo::~HeaderFileInfo", NM = "_ZN5clang14HeaderFileInfoD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang14HeaderFileInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    clear();
  }
  
  public/*inline*/ void clear() {
    this.isImport = false;
    this.isPragmaOnce = false;
    this.DirInfo = (byte) SrcMgr.CharacteristicKind.C_User_Raw;
    this.External = false;
    this.isModuleHeader = false;
    this.isCompilingModuleHeader = false;
    this.Resolved = false;
    this.IndexHeaderMapHeader = false;
    this.IsValid = false;
    this.NumIncludes = 0;
    this.ControllingMacroID = 0;
    this.ControllingMacro = null;
    this.Framework = StringRef.R$EMPTY;
  }

  @Override
  public int $sizeof() {
    return $sizeof_HeaderFileInfo();
  }
  
  public static int $sizeof_HeaderFileInfo() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER 
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BYTE
         + NativeType.BYTES_IN_BOOL 
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BYTE 
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_BOOL
         + NativeType.BYTES_IN_UCHAR
         + NativeType.BYTES_IN_LONG 
         + NativeType.BYTES_IN_JAVA_OBJECT_REF
         + NativeType.BYTES_IN_JAVA_OBJECT_REF;
  }
    
}
