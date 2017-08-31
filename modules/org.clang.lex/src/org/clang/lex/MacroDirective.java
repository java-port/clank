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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief Encapsulates changes to the "macros namespace" (the location where
/// the macro name became active, the location where it was undefined, etc.).
///
/// MacroDirectives, associated with an identifier, are used to model the macro
/// history. Usually a macro definition (MacroInfo) is where a macro name
/// becomes active (MacroDirective) but #pragma push_macro / pop_macro can
/// create additional DefMacroDirectives for the same MacroInfo.
//<editor-fold defaultstate="collapsed" desc="clang::MacroDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 307,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 314,
 FQN="clang::MacroDirective", NM="_ZN5clang14MacroDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirectiveE")
//</editor-fold>
public abstract class MacroDirective {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 316,
   FQN="clang::MacroDirective::Kind", NM="_ZN5clang14MacroDirective4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    MD_Define(0),
    MD_Undefine(MD_Define.getValue() + 1),
    MD_Visibility(MD_Undefine.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  // JAVA: remember position (we need this information for callbacks)
  private /*SourceLocation*/int HashLoc = SourceLocation.getInvalid();
  private /*SourceLocation*/int EodLoc = SourceLocation.getInvalid();

  // JAVA: we need this information for callbacks
  protected void setLocationRange(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc) {
    assert SourceLocation.isInvalid(this.HashLoc) : "must be initialized once";
    assert SourceLocation.isInvalid(this.EodLoc) : "must be initialized once";
    this.HashLoc = HashLoc;
    this.EodLoc = EodLoc;
  }
  
  // JAVA: we need this information for callbacks
  public /*SourceLocation*/int getHashLoc() {
    return HashLoc;
  }

  // JAVA: we need this information for callbacks
  public /*SourceLocation*/int getEodLoc() {
    return EodLoc;
  }
  
/*protected:*/
  /// \brief Previous macro directive for the same identifier, or NULL.
  protected MacroDirective /*P*/ Previous;
  
  protected /*SourceLocation*/int Loc;
  
  /// \brief MacroDirective kind.
  protected /*JBYTE unsigned int*/ Kind MDKind /*: 2*/;
  
  /// \brief True if the macro directive was loaded from a PCH file.
  protected /*JBIT unsigned int*/ boolean IsFromPCH /*: 1*/;
  
  // Used by VisibilityMacroDirective ----------------------------------------//
  
  /// \brief Whether the macro has public visibility (when described in a
  /// module).
  protected /*JBIT unsigned int*/ boolean IsPublic /*: 1*/;
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::MacroDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 329,
   FQN="clang::MacroDirective::MacroDirective", NM="_ZN5clang14MacroDirectiveC1ENS0_4KindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirectiveC1ENS0_4KindENS_14SourceLocationE")
  //</editor-fold>
  protected MacroDirective(Kind K, /*SourceLocation*/int Loc) {
    /* : Previous(null), Loc(Loc), MDKind(K), IsFromPCH(false), IsPublic(true)*/ 
    //START JInit
    this.Previous = null;
    this.Loc = Loc;
    this.MDKind = K;
    this.IsFromPCH = false;
    this.IsPublic = true;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 334,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 377,
   FQN="clang::MacroDirective::getKind", NM="_ZNK5clang14MacroDirective7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return MDKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 379,
   FQN="clang::MacroDirective::getLocation", NM="_ZNK5clang14MacroDirective11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return SourceLocation.getFromRawEncoding(Loc);
  }
  public /*SourceLocation*/int $getLocation() /*const*/ {
    return Loc;
  }

  
  /// \brief Set previous definition of the macro with the same name.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::setPrevious">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 339,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 382,
   FQN="clang::MacroDirective::setPrevious", NM="_ZN5clang14MacroDirective11setPreviousEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective11setPreviousEPS0_")
  //</editor-fold>
  public void setPrevious(MacroDirective /*P*/ Prev) {
    Previous = Prev;
  }

  
  /// \brief Get previous definition of the macro with the same name.
  ////<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getPrevious">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 342,
//   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 387,
//   FQN="clang::MacroDirective::getPrevious", NM="_ZNK5clang14MacroDirective11getPreviousEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective11getPreviousEv")
//  //</editor-fold>
//  public /*const*/ MacroDirective /*P*/ getPrevious() /*const*/ {
//    return Previous;
//  }

  
  /// \brief Get previous definition of the macro with the same name.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getPrevious">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 345,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 390,
   FQN="clang::MacroDirective::getPrevious", NM="_ZN5clang14MacroDirective11getPreviousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective11getPreviousEv")
  //</editor-fold>
  public MacroDirective /*P*/ getPrevious() {
    return Previous;
  }

  
  /// \brief Return true if the macro directive was loaded from a PCH file.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::isFromPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 393,
   FQN="clang::MacroDirective::isFromPCH", NM="_ZNK5clang14MacroDirective9isFromPCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective9isFromPCHEv")
  //</editor-fold>
  public boolean isFromPCH() /*const*/ {
    return IsFromPCH;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::setIsFromPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 350,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 395,
   FQN="clang::MacroDirective::setIsFromPCH", NM="_ZN5clang14MacroDirective12setIsFromPCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective12setIsFromPCHEv")
  //</editor-fold>
  public void setIsFromPCH() {
    IsFromPCH = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 352,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 418,
   FQN="clang::MacroDirective::DefInfo", NM="_ZN5clang14MacroDirective7DefInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoE")
  //</editor-fold>
  public static class DefInfo implements Native.Native$Bool {
    private DefMacroDirective /*P*/ DefDirective;
    private /*SourceLocation*/int UndefLoc;
    private boolean IsPublic;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::DefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 358,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 424,
     FQN="clang::MacroDirective::DefInfo::DefInfo", NM="_ZN5clang14MacroDirective7DefInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoC1Ev")
    //</editor-fold>
    public DefInfo() {
      /* : DefDirective(null), UndefLoc(), IsPublic(true)*/ 
      //START JInit
      this.DefDirective = null;
      this.UndefLoc = SourceLocation.getInvalid();
      this.IsPublic = true;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::DefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 360,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 426,
     FQN="clang::MacroDirective::DefInfo::DefInfo", NM="_ZN5clang14MacroDirective7DefInfoC1EPNS_17DefMacroDirectiveENS_14SourceLocationEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoC1EPNS_17DefMacroDirectiveENS_14SourceLocationEb")
    //</editor-fold>
    public DefInfo(DefMacroDirective /*P*/ DefDirective, /*SourceLocation*/int UndefLoc, 
        boolean isPublic) {
      /* : DefDirective(DefDirective), UndefLoc(UndefLoc), IsPublic(isPublic)*/ 
      //START JInit
      this.DefDirective = DefDirective;
      this.UndefLoc = UndefLoc;
      this.IsPublic = isPublic;
      //END JInit
    }

    
    ////<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getDirective">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 364,
//     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 430,
//     FQN="clang::MacroDirective::DefInfo::getDirective", NM="_ZNK5clang14MacroDirective7DefInfo12getDirectiveEv",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo12getDirectiveEv")
//    //</editor-fold>
//    public /*const*/ DefMacroDirective /*P*/ getDirective() /*const*/ {
//      return DefDirective;
//    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getDirective">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 365,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 431,
     FQN="clang::MacroDirective::DefInfo::getDirective", NM="_ZN5clang14MacroDirective7DefInfo12getDirectiveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfo12getDirectiveEv")
    //</editor-fold>
    public DefMacroDirective /*P*/ getDirective() {
      return DefDirective;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 471,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 561,
     FQN="clang::MacroDirective::DefInfo::getLocation", NM="_ZNK5clang14MacroDirective7DefInfo11getLocationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo11getLocationEv")
    //</editor-fold>
    public /*inline*/ /*SourceLocation*/int getLocation() /*const*/ {
      if (isInvalid()) {
        return SourceLocation.getInvalid();
      }
      return DefDirective.$getLocation();
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 477,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 567,
     FQN="clang::MacroDirective::DefInfo::getMacroInfo", NM="_ZN5clang14MacroDirective7DefInfo12getMacroInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfo12getMacroInfoEv")
    //</editor-fold>
    public /*inline*/ MacroInfo /*P*/ getMacroInfo() {
      if (isInvalid()) {
        return null;
      }
      return DefDirective.getInfo();
    }

    ////<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 369,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 435,
     FQN="clang::MacroDirective::DefInfo::getMacroInfo", NM="_ZNK5clang14MacroDirective7DefInfo12getMacroInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo12getMacroInfoEv")
    //</editor-fold>
    public /*const*/ MacroInfo /*P*/ getMacroInfo$Const() /*const*/ {
      return ((/*const_cast*/DefInfo /*P*/ )(this)).getMacroInfo();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getUndefLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 373,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 439,
     FQN="clang::MacroDirective::DefInfo::getUndefLocation", NM="_ZNK5clang14MacroDirective7DefInfo16getUndefLocationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo16getUndefLocationEv")
    //</editor-fold>
    public /*SourceLocation*/int getUndefLocation() /*const*/ {
      return UndefLoc;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::isUndefined">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 374,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 440,
     FQN="clang::MacroDirective::DefInfo::isUndefined", NM="_ZNK5clang14MacroDirective7DefInfo11isUndefinedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo11isUndefinedEv")
    //</editor-fold>
    public boolean isUndefined() /*const*/ {
      return SourceLocation.isValid(UndefLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::isPublic">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 376,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 442,
     FQN="clang::MacroDirective::DefInfo::isPublic", NM="_ZNK5clang14MacroDirective7DefInfo8isPublicEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo8isPublicEv")
    //</editor-fold>
    public boolean isPublic() /*const*/ {
      return IsPublic;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 378,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 444,
     FQN="clang::MacroDirective::DefInfo::isValid", NM="_ZNK5clang14MacroDirective7DefInfo7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return DefDirective != null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::isInvalid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 379,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 445,
     FQN="clang::MacroDirective::DefInfo::isInvalid", NM="_ZNK5clang14MacroDirective7DefInfo9isInvalidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo9isInvalidEv")
    //</editor-fold>
    public boolean isInvalid() /*const*/ {
      return !isValid();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 381,
     FQN="clang::MacroDirective::DefInfo::operator bool", NM="_ZNK5clang14MacroDirective7DefInfocvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfocvbEv")
    //</editor-fold>
    public boolean $bool() /*const*/ {
      return isValid();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getPreviousDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 483,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 573,
     FQN="clang::MacroDirective::DefInfo::getPreviousDefinition", NM="_ZN5clang14MacroDirective7DefInfo21getPreviousDefinitionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfo21getPreviousDefinitionEv")
    //</editor-fold>
    public /*inline*/ MacroDirective.DefInfo getPreviousDefinition() {
      if (isInvalid() || DefDirective.getPrevious() == null) {
        return new DefInfo();
      }
      return DefDirective.getPrevious().getDefinition();
    }

    ////<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::getPreviousDefinition">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 384,
//     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 450,
//     FQN="clang::MacroDirective::DefInfo::getPreviousDefinition", NM="_ZNK5clang14MacroDirective7DefInfo21getPreviousDefinitionEv",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective7DefInfo21getPreviousDefinitionEv")
//    //</editor-fold>
//    public /*const*/ DefInfo getPreviousDefinition() /*const*/ {
//      return ((/*const_cast*/DefInfo /*P*/ )(this)).getPreviousDefinition();
//    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::DefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 352,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 418,
     FQN="clang::MacroDirective::DefInfo::DefInfo", NM="_ZN5clang14MacroDirective7DefInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DefInfo(/*const*/ DefInfo /*&*/ $Prm0) {
      /* : DefDirective(.DefDirective), UndefLoc(.UndefLoc), IsPublic(.IsPublic)*/ 
      //START JInit
      this.DefDirective = $Prm0.DefDirective;
      this.UndefLoc = $Prm0.UndefLoc;
      this.IsPublic = $Prm0.IsPublic;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::DefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 352,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 418,
     FQN="clang::MacroDirective::DefInfo::DefInfo", NM="_ZN5clang14MacroDirective7DefInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ DefInfo(JD$Move _dparam, DefInfo /*&&*/$Prm0) {
      /* : DefDirective(static_cast<DefInfo &&>().DefDirective), UndefLoc(static_cast<DefInfo &&>().UndefLoc), IsPublic(static_cast<DefInfo &&>().IsPublic)*/ 
      //START JInit
      this.DefDirective = $Prm0.DefDirective;
      this.UndefLoc = $Prm0.UndefLoc;
      this.IsPublic = $Prm0.IsPublic;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 352,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 418,
     FQN="clang::MacroDirective::DefInfo::operator=", NM="_ZN5clang14MacroDirective7DefInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang14MacroDirective7DefInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ DefInfo /*&*/ $assign(/*const*/ DefInfo /*&*/ $Prm0) {
      this.DefDirective = $Prm0.DefDirective;
      this.UndefLoc = $Prm0.UndefLoc;
      this.IsPublic = $Prm0.IsPublic;
      return /*Deref*/this;
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::DefInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 352,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 418,
     FQN="clang::MacroDirective::DefInfo::operator=", NM="_ZN5clang14MacroDirective7DefInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7DefInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ DefInfo /*&*/ $assignMove(DefInfo /*&&*/$Prm0) {
      this.DefDirective = $Prm0.DefDirective;
      this.UndefLoc = $Prm0.UndefLoc;
      this.IsPublic = $Prm0.IsPublic;
      return /*Deref*/this;
    }

    
    public String toString() {
      return "" + "DefDirective=" + DefDirective // NOI18N
                + ", UndefLoc=" + UndefLoc // NOI18N
                + ", IsPublic=" + IsPublic; // NOI18N
    }
  };
  
  /// \brief Traverses the macro directives history and returns the next
  /// macro definition directive along with info about its undefined location
  /// (if there is one) and if it is public or private.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", old_line = 172,
   FQN="clang::MacroDirective::getDefinition", NM="_ZN5clang14MacroDirective13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective13getDefinitionEv")
  //</editor-fold>
  public MacroDirective.DefInfo getDefinition() {
      MacroDirective /*P*/ MD = this;
      /*SourceLocation*/int UndefLoc/*J*/= SourceLocation.getInvalid();
      boolean isPublic$hasValue = false;
      boolean isPublic$Value = false;
      for (; (MD != null); MD = MD.getPrevious()) {
        {
          if (MD instanceof DefMacroDirective) {
            return new DefInfo((DefMacroDirective)MD, UndefLoc, !isPublic$hasValue || isPublic$Value);
          }
        }
        {
          
          if (MD instanceof UndefMacroDirective) {
            UndefLoc = MD.$getLocation();
            continue;
          }
        }
        
        VisibilityMacroDirective /*P*/ VisMD = (VisibilityMacroDirective)(MD);
        if (!isPublic$hasValue) {
          isPublic$hasValue = true;
          isPublic$Value = VisMD.isPublic();
        }
      }
      
    return new DefInfo((DefMacroDirective /*P*/ )null, UndefLoc, 
       !isPublic$hasValue || isPublic$Value);
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 459,
   FQN="clang::MacroDirective::getDefinition", NM="_ZNK5clang14MacroDirective13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective13getDefinitionEv")
  //</editor-fold>
  public /*const*/ DefInfo getDefinition$Const() /*const*/ {
    return ((/*const_cast*/MacroDirective /*P*/ )(this)).getDefinition();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::isDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 397,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 463,
   FQN="clang::MacroDirective::isDefined", NM="_ZNK5clang14MacroDirective9isDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective9isDefinedEv")
  //</editor-fold>
  public boolean isDefined() /*const*/ {
    {
      /*const*/ DefInfo Def = getDefinition();
      if (Def.$bool()) {
        return !Def.isUndefined();
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 403,
   FQN="clang::MacroDirective::getMacroInfo", NM="_ZNK5clang14MacroDirective12getMacroInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective12getMacroInfoEv")
  //</editor-fold>
  public /*const*/ MacroInfo /*P*/ getMacroInfo$Const() /*const*/ {
    return getDefinition$Const().getMacroInfo$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 406,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 472,
   FQN="clang::MacroDirective::getMacroInfo", NM="_ZN5clang14MacroDirective12getMacroInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective12getMacroInfoEv")
  //</editor-fold>
  public MacroInfo /*P*/ getMacroInfo() {
    return getDefinition().getMacroInfo();
  }


  /// \brief Find macro definition active in the specified source location. If
  /// this macro was not defined there, return NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::findDirectiveAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", old_line = 195,
   FQN="clang::MacroDirective::findDirectiveAtLoc", NM="_ZNK5clang14MacroDirective18findDirectiveAtLocENS_14SourceLocationERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective18findDirectiveAtLocENS_14SourceLocationERNS_13SourceManagerE")
  //</editor-fold>
  public /*const*/MacroDirective.DefInfo findDirectiveAtLoc(SourceLocation L, SourceManager /*&*/ SM) /*const*/ {
    return findDirectiveAtLoc(L.getRawEncoding(), SM);
  }
  public /*const*/MacroDirective.DefInfo findDirectiveAtLoc(/*SourceLocation*/int L, SourceManager /*&*/ SM) /*const*/ {
    assert (SourceLocation.isValid(L)) : "SourceLocation is invalid.";
    for (DefInfo Def = getDefinition(); Def.$bool(); Def.$assign(Def.getPreviousDefinition())) {
      if (SourceLocation.isInvalid(Def.getLocation()) || SM.isBeforeInTranslationUnit(Def.getLocation(), L)) {
        return (!Def.isUndefined() || SM.isBeforeInTranslationUnit(L, Def.getUndefLocation())) ? Def : new DefInfo();
      }
    }
    return new DefInfo();
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp", old_line = 208,
   FQN="clang::MacroDirective::dump", NM="_ZNK5clang14MacroDirective4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZNK5clang14MacroDirective4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    dump(llvm.errs());
  }
  public void dump(raw_ostream /*&*/ Out/*=llvm.errs()*/)  /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    switch (getKind()) {
     case MD_Define:
      Out.$out(/*KEEP_STR*/"DefMacroDirective");
      break;
     case MD_Undefine:
      Out.$out(/*KEEP_STR*/"UndefMacroDirective");
      break;
     case MD_Visibility:
      Out.$out(/*KEEP_STR*/"VisibilityMacroDirective");
      break;
    }
    Out.$out(/*KEEP_STR*/$SPACE).$out(this);
    {
      // FIXME: Dump SourceLocation.
      /*const*/ MacroDirective /*P*/ Prev = getPrevious();
      if ((Prev != null)) {
        Out.$out(/*KEEP_STR*/" prev ").$out(Prev);
      }
    }
    if (IsFromPCH) {
      Out.$out(/*KEEP_STR*/" from_pch");
    }
    if (isa(VisibilityMacroDirective.class, this)) {
      Out.$out((IsPublic ? $(" public") : $(" private")));
    }
    {
      
      /*const*/ DefMacroDirective /*P*/ DMD = dyn_cast(DefMacroDirective.class, this);
      if ((DMD != null)) {
        {
          /*const*/ MacroInfo /*P*/ Info = DMD.getInfo();
          if ((Info != null)) {
            Out.$out(/*KEEP_STR*/"\n  ");
            Info.dump(Out);
          }
        }
      }
    }
    Out.$out(/*KEEP_STR*/$LF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MacroDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", line = 414,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/MacroInfo.h", old_line = 482,
   FQN="clang::MacroDirective::classof", NM="_ZN5clang14MacroDirective7classofEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/MacroInfo.cpp -nm=_ZN5clang14MacroDirective7classofEPKS0_")
  //</editor-fold>
  public static boolean classof(/*const*/ MacroDirective /*P*/ $Prm0) {
    return true;
  }

  
  public String toString() {
    return "" + "Previous=" + Previous // NOI18N
              + ", Loc=" + SourceLocation.toString(Loc) // NOI18N
              + ", MDKind=" + MDKind // NOI18N
              + ", IsFromPCH=" + IsFromPCH // NOI18N
              + ", IsPublic=" + IsPublic; // NOI18N
  }
}
