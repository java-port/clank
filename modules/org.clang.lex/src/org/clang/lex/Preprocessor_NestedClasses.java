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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_NestedClasses">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_NestedEnums ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor10MacroStateE;_ZN5clang12Preprocessor14MacroInfoChainE;_ZN5clang12Preprocessor14SubmoduleStateE;_ZN5clang12Preprocessor15ModuleMacroInfoE;_ZN5clang12Preprocessor16IncludeStackInfoE;_ZN5clang12Preprocessor16MacroExpandsInfoE;_ZN5clang12Preprocessor21BuildingSubmoduleInfoE;_ZN5clang12Preprocessor25ResetMacroExpansionHelperE;_ZN5clang12Preprocessor26DeserializedMacroInfoChainE; -static-type=Preprocessor_NestedClasses -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_NestedClasses extends Preprocessor_NestedEnums {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


//===----------------------------------------------------------------------===//
// Preprocessor Directive Handling.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ResetMacroExpansionHelper">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 736,
   FQN="clang::Preprocessor::ResetMacroExpansionHelper", NM="_ZN5clang12Preprocessor25ResetMacroExpansionHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor25ResetMacroExpansionHelperE")
  //</editor-fold>
  protected /*private*/ static final class ResetMacroExpansionHelper implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ResetMacroExpansionHelper::ResetMacroExpansionHelper">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 879,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 738,
     FQN="clang::Preprocessor::ResetMacroExpansionHelper::ResetMacroExpansionHelper", NM="_ZN5clang12Preprocessor25ResetMacroExpansionHelperC1EPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor25ResetMacroExpansionHelperC1EPS0_")
    //</editor-fold>
    public ResetMacroExpansionHelper(Preprocessor /*P*/ pp) {
      /* : PP(pp), save(pp.DisableMacroExpansion)*/ 
      //START JInit
      this.PP = pp;
      //END JInit
      savePPStates(pp);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    protected /*private*/ void savePPStates(Preprocessor pp) {
      this.save = savePPStatesImpl(pp);
    }
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    protected /*private*/ static boolean savePPStatesImpl(Preprocessor pp) {
      boolean SavedBool = pp.DisableMacroExpansion;
      if (pp.MacroExpansionInDirectivesOverride) {
        pp.DisableMacroExpansion = false;
      }
      return SavedBool;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ResetMacroExpansionHelper::~ResetMacroExpansionHelper">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 885,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 743,
     FQN="clang::Preprocessor::ResetMacroExpansionHelper::~ResetMacroExpansionHelper", NM="_ZN5clang12Preprocessor25ResetMacroExpansionHelperD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor25ResetMacroExpansionHelperD0Ev")
    //</editor-fold>
    public void $destroy() { 
      restore(this.PP, this.save);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    protected /*private*/ static void restore(Preprocessor PP, boolean save) {
    // JAVA: support ResetMacroExpansionOnlyInDirectives
      if (PP.MacroExpansionInDirectivesOverride) {
        // if no external changes, then restore old state, otherwise new state is already set
        PP.DisableMacroExpansion = save; 
      }
    }
    
    /*for caches only*/protected /*private*/ ResetMacroExpansionHelper(JD$Misc dummy, Preprocessor /*P*/ pp) {
      this.PP = pp;
    }
  /*private:*/
    protected /*private*/ final Preprocessor /*P*/ PP;
    protected /*private*/ boolean save;

    public String toString() {
      return "save=" + save; // NOI18N
    }
  }

/// \brief Keeps track of the stack of files currently
/// \#included, and macros currently being expanded from, not counting
/// CurLexer/CurTokenLexer.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncludeStackInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 326,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 325,
   FQN="clang::Preprocessor::IncludeStackInfo", NM="_ZN5clang12Preprocessor16IncludeStackInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16IncludeStackInfoE")
  //</editor-fold>
  public static class/*struct*/ IncludeStackInfo implements Native.assignable<IncludeStackInfo>, 
          NativeType.SizeofCapable, Destructors.ClassWithDestructor {
    // JAVA: constant to be used as defaultValue in other collections.
    // this instance is cloned, but have not be modified  
    public static final IncludeStackInfo DEFAULT = new IncludeStackInfo();
    
    public CurLexerKindEnum CurLexerKind;
    public Module /*P*/ TheSubmodule;
    public std.unique_ptr<Lexer> TheLexer;
    public std.unique_ptr<PTHLexer> ThePTHLexer;
    public PreprocessorLexer /*P*/ ThePPLexer;
    public std.unique_ptr<TokenLexer> TheTokenLexer;
    public /*const*/type$ptr<DirectoryLookup> /*P*/ TheDirLookup;
    
    // JAVA: default constructor
    public IncludeStackInfo() {
      /* For default value purposes */
      this.TheLexer = new std.unique_ptr<Lexer>();
      this.ThePTHLexer = new std.unique_ptr<PTHLexer>();
      this.TheTokenLexer = new std.unique_ptr<TokenLexer>();
    }

    // The following constructors are completely useless copies of the default
    // versions, only needed to pacify MSVC.
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncludeStackInfo::IncludeStackInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 337,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 336,
     FQN="clang::Preprocessor::IncludeStackInfo::IncludeStackInfo", NM="_ZN5clang12Preprocessor16IncludeStackInfoC1ENS0_12CurLexerKindEPNS_6ModuleEOSt10unique_ptrINS_5LexerESt14default_deleteIS6_EEOS5_INS_8PTHLexerES7_ISB_EEPNS_17PreprocessorLexerEOS5_INS_10TokenLexerES7_ISH_EEPKNS_15DirectoryLookupE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16IncludeStackInfoC1ENS0_12CurLexerKindEPNS_6ModuleEOSt10unique_ptrINS_5LexerESt14default_deleteIS6_EEOS5_INS_8PTHLexerES7_ISB_EEPNS_17PreprocessorLexerEOS5_INS_10TokenLexerES7_ISH_EEPKNS_15DirectoryLookupE")
    //</editor-fold>
    public IncludeStackInfo(CurLexerKindEnum CurLexerKind, Module /*P*/ TheSubmodule, 
        std.unique_ptr<Lexer> /*&&*/TheLexer, 
        std.unique_ptr<PTHLexer> /*&&*/ThePTHLexer, 
        PreprocessorLexer /*P*/ ThePPLexer, 
        std.unique_ptr<TokenLexer> /*&&*/TheTokenLexer, 
        /*const*/type$ptr<DirectoryLookup> /*P*/ TheDirLookup) {
      /* : CurLexerKind(std::move(CurLexerKind)), TheSubmodule(std::move(TheSubmodule)), TheLexer(std::move(TheLexer)), ThePTHLexer(std::move(ThePTHLexer)), ThePPLexer(std::move(ThePPLexer)), TheTokenLexer(std::move(TheTokenLexer)), TheDirLookup(std::move(TheDirLookup))*/ 
      //START JInit
      this.CurLexerKind = std.move(CurLexerKind);
      this.TheSubmodule = std.move(TheSubmodule);
      this.TheLexer = new std.unique_ptr<Lexer>(TheLexer.release());
      this.ThePTHLexer = new std.unique_ptr<PTHLexer>(ThePTHLexer.release());
      this.ThePPLexer = ThePPLexer;
      this.TheTokenLexer = new std.unique_ptr<TokenLexer>(TheTokenLexer.release());
      this.TheDirLookup = TheDirLookup;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncludeStackInfo::IncludeStackInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 349,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 348,
     FQN="clang::Preprocessor::IncludeStackInfo::IncludeStackInfo", NM="_ZN5clang12Preprocessor16IncludeStackInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16IncludeStackInfoC1EOS1_")
    //</editor-fold>
    public IncludeStackInfo(JD$Move _dparam, IncludeStackInfo /*&&*/RHS) {
      /* : CurLexerKind(std::move(RHS.CurLexerKind)), TheSubmodule(std::move(RHS.TheSubmodule)), TheLexer(std::move(RHS.TheLexer)), ThePTHLexer(std::move(RHS.ThePTHLexer)), ThePPLexer(std::move(RHS.ThePPLexer)), TheTokenLexer(std::move(RHS.TheTokenLexer)), TheDirLookup(std::move(RHS.TheDirLookup))*/ 
      //START JInit
      this.CurLexerKind = std.move(RHS.CurLexerKind);
      this.TheSubmodule = std.move(RHS.TheSubmodule);
      this.TheLexer = new std.unique_ptr<Lexer>(RHS.TheLexer.release());
      this.ThePTHLexer = new std.unique_ptr<PTHLexer>(RHS.ThePTHLexer.release());
      this.ThePPLexer = RHS.ThePPLexer;
      this.TheTokenLexer = new std.unique_ptr<TokenLexer>(RHS.TheTokenLexer.release());
      this.TheDirLookup = RHS.TheDirLookup;
      //END JInit
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncludeStackInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 326,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 325,
     FQN="clang::Preprocessor::IncludeStackInfo::operator=", NM="_ZN5clang12Preprocessor16IncludeStackInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16IncludeStackInfoaSERKS1_")
    //</editor-fold>
    @Override public /*inline*/ IncludeStackInfo /*&*/ $assign(/*const*/IncludeStackInfo /*&*/ RHS)/* throw()*/ {
      // JAVA:
      this.CurLexerKind = RHS.CurLexerKind;
      this.TheSubmodule = RHS.TheSubmodule;
      this.TheLexer.$assignMove(RHS.TheLexer);
      this.ThePTHLexer.$assignMove(RHS.ThePTHLexer);
      this.ThePPLexer = RHS.ThePPLexer;
      this.TheTokenLexer.$assignMove(RHS.TheTokenLexer);
      this.TheDirLookup = RHS.TheDirLookup;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncludeStackInfo::~IncludeStackInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 326,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 325,
     FQN="clang::Preprocessor::IncludeStackInfo::~IncludeStackInfo", NM="_ZN5clang12Preprocessor16IncludeStackInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16IncludeStackInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      // JAVA: this is reusable instance, do not destroy unique_ptr, but reset
      TheTokenLexer.$assign_nullptr_t(null);
      ThePTHLexer.$assign_nullptr_t(null);
      TheLexer.$assign_nullptr_t(null);
      
      this.CurLexerKind = null;
      this.TheSubmodule = null;
      this.ThePPLexer = null;
      this.TheDirLookup = null;
    }

    @Override
    public int $sizeof() {
      return $sizeof_IncludeStackInfo();
    }
    
    public static int $sizeof_IncludeStackInfo() {
      return NativeType.BYTES_IN_JAVA_OBJECT_HEADER +
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF + 
             NativeType.BYTES_IN_JAVA_OBJECT_REF;
    }

    public String toString() {
      return "" + "CurLexerKind=" + CurLexerKind // NOI18N
                + ", TheSubmodule=" + TheSubmodule // NOI18N
                + ", TheLexer=" + TheLexer // NOI18N
                + ", ThePTHLexer=" + ThePTHLexer // NOI18N
                + ", ThePPLexer=" + ThePPLexer // NOI18N
                + ", TheTokenLexer=" + TheTokenLexer // NOI18N
                + ", TheDirLookup=" + TheDirLookup; // NOI18N
    }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroExpandsInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 363,
   FQN="clang::Preprocessor::MacroExpandsInfo", NM="_ZN5clang12Preprocessor16MacroExpandsInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16MacroExpandsInfoE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ MacroExpandsInfo implements Native.NativePOD<MacroExpandsInfo> {
    public Token Tok;
    public MacroDefinition MD;
    public SourceRange Range;
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroExpandsInfo::MacroExpandsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 368,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 367,
     FQN="clang::Preprocessor::MacroExpandsInfo::MacroExpandsInfo", NM="_ZN5clang12Preprocessor16MacroExpandsInfoC1ENS_5TokenENS_15MacroDefinitionENS_11SourceRangeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16MacroExpandsInfoC1ENS_5TokenENS_15MacroDefinitionENS_11SourceRangeE")
    //</editor-fold>
    public MacroExpandsInfo(Token Tok, MacroDefinition MD, SourceRange Range) {
      /* : Tok(Tok), MD(MD), Range(Range)*/ 
      //START JInit
      this.Tok = new Token(Tok);
      this.MD = new MacroDefinition(MD);
      this.Range = new SourceRange(Range);
      //END JInit
    }

    public MacroExpandsInfo() {
      this.MD = new MacroDefinition();
      this.Tok = new Token();
      this.Range = new SourceRange();
    }

    @Override
    public MacroExpandsInfo clone() {
      return new MacroExpandsInfo(Tok, MD, Range);
    }

    @Override
    public MacroExpandsInfo $assign(MacroExpandsInfo value) {
      this.MD.$assign(MD);
      this.Tok.$assign(value.Tok);
      this.Range.$assign(value.Range);
      return this;
    }

    @Override
    public boolean $noteq(MacroExpandsInfo other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(MacroExpandsInfo other) {
      return Range.$eq(other.Range) && Tok.$eq(other.Tok) && MD.$eq(other.MD);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroExpandsInfo::~MacroExpandsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 364,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 363,
     FQN="clang::Preprocessor::MacroExpandsInfo::~MacroExpandsInfo", NM="_ZN5clang12Preprocessor16MacroExpandsInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang12Preprocessor16MacroExpandsInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    public String toString() {
      return "" + "Tok=" + Tok // NOI18N
                + ", MD=" + MD // NOI18N
                + ", Range=" + Range; // NOI18N
    }
  }

/// Information about a name that has been used to define a module macro.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ModuleMacroInfo">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 374,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 373,
   FQN="clang::Preprocessor::ModuleMacroInfo", NM="_ZN5clang12Preprocessor15ModuleMacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor15ModuleMacroInfoE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ModuleMacroInfo implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ModuleMacroInfo::ModuleMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 375,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 374,
     FQN="clang::Preprocessor::ModuleMacroInfo::ModuleMacroInfo", NM="_ZN5clang12Preprocessor15ModuleMacroInfoC1EPNS_14MacroDirectiveE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor15ModuleMacroInfoC1EPNS_14MacroDirectiveE")
    //</editor-fold>
    public ModuleMacroInfo(MacroDirective /*P*/ MD) {
      /* : MD(MD), ActiveModuleMacros(), ActiveModuleMacrosGeneration(0), IsAmbiguous(false), OverriddenMacros()*/ 
      //START JInit
      this.MD = MD;
      this.ActiveModuleMacros = new TinyPtrVector<ModuleMacro /*P*/ >();
      this.ActiveModuleMacrosGeneration = 0;
      this.IsAmbiguous = false;
      this.OverriddenMacros = new TinyPtrVector<ModuleMacro /*P*/ >();
      //END JInit
    }

    
    /// The most recent macro directive for this identifier.
    public MacroDirective /*P*/ MD;
    /// The active module macros for this identifier.
    public TinyPtrVector<ModuleMacro /*P*/ > ActiveModuleMacros;
    /// The generation number at which we last updated ActiveModuleMacros.
    /// \see Preprocessor::VisibleModules.
    public /*uint*/int ActiveModuleMacrosGeneration;
    /// Whether this macro name is ambiguous.
    public boolean IsAmbiguous;
    /// The module macros that are overridden by this macro.
    public TinyPtrVector<ModuleMacro /*P*/ > OverriddenMacros;
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ModuleMacroInfo::~ModuleMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 374,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 373,
     FQN="clang::Preprocessor::ModuleMacroInfo::~ModuleMacroInfo", NM="_ZN5clang12Preprocessor15ModuleMacroInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor15ModuleMacroInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      OverriddenMacros.$destroy();
      ActiveModuleMacros.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "MD=" + MD // NOI18N
                + ", ActiveModuleMacros=" + ActiveModuleMacros // NOI18N
                + ", ActiveModuleMacrosGeneration=" + ActiveModuleMacrosGeneration // NOI18N
                + ", IsAmbiguous=" + IsAmbiguous // NOI18N
                + ", OverriddenMacros=" + OverriddenMacros; // NOI18N
    }
  }

/// The state of a macro for an identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 392,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 391,
   FQN="clang::Preprocessor::MacroState", NM="_ZN5clang12Preprocessor10MacroStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateE")
  //</editor-fold>
  /*friend*/public static class MacroState implements Destructors.ClassWithDestructor, NativePOD<MacroState>, NativeMoveable<MacroState> {
    protected /*private*/ /*mutable */PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ > State;

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::getModuleInfo">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 395,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 394,
     FQN="clang::Preprocessor::MacroState::getModuleInfo", NM="_ZNK5clang12Preprocessor10MacroState13getModuleInfoERS0_PKNS_14IdentifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState13getModuleInfoERS0_PKNS_14IdentifierInfoE")
    //</editor-fold>
    protected /*private*/ ModuleMacroInfo /*P*/ getModuleInfo(Preprocessor /*&*/ PP, 
                 /*const*/ IdentifierInfo /*P*/ II) /*const*/ {
      assert this != DEFAULT;
      // FIXME: Find a spare bit on IdentifierInfo and store a
      //        HasModuleMacros flag.
      if (!II.hasMacroDefinition()
         || (!PP.getLangOpts().Modules
         && !PP.getLangOpts().ModulesLocalVisibility)
         || !(PP.CurSubmoduleState.VisibleModules.getGeneration() != 0)) {
        return null;
      }

      ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
      if (!(Info != null)) {
        Info = /*FIXME:*//*new (PP.getPreprocessorAllocator())*/ new ModuleMacroInfo(State.get(MacroDirective /*P*/ .class));
        State.$assign_T1$C$R(ModuleMacroInfo /*P*/.class, Info);
      }
      if (PP.CurSubmoduleState.VisibleModules.getGeneration()
         != Info.ActiveModuleMacrosGeneration) {
        PP.updateModuleMacroInfo(II, $Deref(Info));
      }
      return Info;
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::MacroState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 419,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 418,
     FQN="clang::Preprocessor::MacroState::MacroState", NM="_ZN5clang12Preprocessor10MacroStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateC1Ev")
    //</editor-fold>
    public MacroState() {
      /* : MacroState(null)*/ 
      //START JInit
      this((MacroDirective /*P*/ )null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::MacroState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 420,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 419,
     FQN="clang::Preprocessor::MacroState::MacroState", NM="_ZN5clang12Preprocessor10MacroStateC1EPNS_14MacroDirectiveE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateC1EPNS_14MacroDirectiveE")
    //</editor-fold>
    public MacroState(MacroDirective /*P*/ MD) {
      // : State(MD) 
      //START JInit
      this.State = new PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ >(JD$T.INSTANCE, MacroDirective /*P*/ .class, MD);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::MacroState">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 421,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 420,
     FQN="clang::Preprocessor::MacroState::MacroState", NM="_ZN5clang12Preprocessor10MacroStateC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateC1EOS1_")
    //</editor-fold>
    public MacroState(JD$Move _dparam, MacroState /*&&*/O) {
      assert O != DEFAULT;
      /* : State(O.State)*/ 
      //START JInit
      this.State = new PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ >(O.State);
      //END JInit
      O.State.$assign_T$C$R(MacroDirective /*P*/.class, (MacroDirective /*P*/ )null);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::operator=">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 424,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 423,
     FQN="clang::Preprocessor::MacroState::operator=", NM="_ZN5clang12Preprocessor10MacroStateaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateaSEOS1_")
    //</editor-fold>
    public MacroState /*&*/ $assignMove(MacroState /*&&*/O) {
      assert this != DEFAULT;
      PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ > S = new PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ >(O.State);
      O.State.$assign_T$C$R(MacroDirective /*P*/.class, (MacroDirective /*P*/ )null);
      State.$assign(S);
      return /*Deref*/this;
    }
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public MacroState /*&*/ $assign(MacroState /*&&*/O) {
      assert this != DEFAULT;
      State.$assign(new PointerUnion<MacroDirective /*P*/ , ModuleMacroInfo /*P*/ >(O.State));
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::~MacroState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 430,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 429,
     FQN="clang::Preprocessor::MacroState::~MacroState", NM="_ZN5clang12Preprocessor10MacroStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroStateD0Ev")
    //</editor-fold>
    public void $destroy() {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
        if ((Info != null)) {
          Info.$destroy();
        }
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::getLatest">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 435,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 434,
     FQN="clang::Preprocessor::MacroState::getLatest", NM="_ZNK5clang12Preprocessor10MacroState9getLatestEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState9getLatestEv")
    //</editor-fold>
    public MacroDirective /*P*/ getLatest() /*const*/ {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
        if ((Info != null)) {
          return Info.MD;
        }
      }
      return State.get(MacroDirective /*P*/ .class);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::setLatest">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 440,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 439,
     FQN="clang::Preprocessor::MacroState::setLatest", NM="_ZN5clang12Preprocessor10MacroState9setLatestEPNS_14MacroDirectiveE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroState9setLatestEPNS_14MacroDirectiveE")
    //</editor-fold>
    public void setLatest(MacroDirective /*P*/ MD) {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
        if ((Info != null)) {
          Info.MD = MD;
        } else {
          State.$assign_T$C$R(MacroDirective /*P*/.class, MD);
        }
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::isAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 447,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 446,
     FQN="clang::Preprocessor::MacroState::isAmbiguous", NM="_ZNK5clang12Preprocessor10MacroState11isAmbiguousERS0_PKNS_14IdentifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState11isAmbiguousERS0_PKNS_14IdentifierInfoE")
    //</editor-fold>
    public boolean isAmbiguous(Preprocessor /*&*/ PP, /*const*/ IdentifierInfo /*P*/ II) /*const*/ {
      assert this != DEFAULT;
      ModuleMacroInfo /*P*/ Info = getModuleInfo(PP, II);
      return (Info != null) ? Info.IsAmbiguous : false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::getActiveModuleMacros">
    @Converted(kind = Converted.Kind.MANUAL,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 451,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 450,
     FQN="clang::Preprocessor::MacroState::getActiveModuleMacros", NM="_ZNK5clang12Preprocessor10MacroState21getActiveModuleMacrosERS0_PKNS_14IdentifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState21getActiveModuleMacrosERS0_PKNS_14IdentifierInfoE")
    //</editor-fold>
    public ArrayRef<ModuleMacro /*P*/ > getActiveModuleMacros(Preprocessor /*&*/ PP, /*const*/ IdentifierInfo /*P*/ II) /*const*/ {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = getModuleInfo(PP, II);
        if ((Info != null)) {
          return Info.ActiveModuleMacros.$MutableArrayRef$EltTy();
        }
      }
      return ArrayRef.<ModuleMacro /*P*/ >None();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::findDirectiveAtLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 458,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 457,
     FQN="clang::Preprocessor::MacroState::findDirectiveAtLoc", NM="_ZNK5clang12Preprocessor10MacroState18findDirectiveAtLocENS_14SourceLocationERNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState18findDirectiveAtLocENS_14SourceLocationERNS_13SourceManagerE")
    //</editor-fold>
    public MacroDirective.DefInfo findDirectiveAtLoc(SourceLocation Loc, 
                      SourceManager /*&*/ SourceMgr) /*const*/ {
      assert this != DEFAULT;
      {
        // FIXME: Incorporate module macros into the result of this.
        MacroDirective /*P*/ Latest = getLatest();
        if ((Latest != null)) {
          return Latest.findDirectiveAtLoc(new SourceLocation(Loc), SourceMgr);
        }
      }
      return new MacroDirective.DefInfo();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::overrideActiveModuleMacros">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 466,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 465,
     FQN="clang::Preprocessor::MacroState::overrideActiveModuleMacros", NM="_ZN5clang12Preprocessor10MacroState26overrideActiveModuleMacrosERS0_PNS_14IdentifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroState26overrideActiveModuleMacrosERS0_PNS_14IdentifierInfoE")
    //</editor-fold>
    public void overrideActiveModuleMacros(Preprocessor /*&*/ PP, IdentifierInfo /*P*/ II) {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = getModuleInfo(PP, II);
        if ((Info != null)) {
          Info.OverriddenMacros.insert(Info.OverriddenMacros.end(), 
              Info.ActiveModuleMacros.begin(), 
              Info.ActiveModuleMacros.end());
          Info.ActiveModuleMacros.clear();
          Info.IsAmbiguous = false;
        }
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::getOverriddenMacros">
    @Converted(kind = Converted.Kind.MANUAL,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 475,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 474,
     FQN="clang::Preprocessor::MacroState::getOverriddenMacros", NM="_ZNK5clang12Preprocessor10MacroState19getOverriddenMacrosEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor10MacroState19getOverriddenMacrosEv")
    //</editor-fold>
    public ArrayRef<ModuleMacro /*P*/ > getOverriddenMacros() /*const*/ {
      assert this != DEFAULT;
      {
        ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
        if ((Info != null)) {
          return Info.OverriddenMacros.$MutableArrayRef$EltTy();
        }
      }
      return ArrayRef.<ModuleMacro /*P*/ >None();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroState::setOverriddenMacros">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 480,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 479,
     FQN="clang::Preprocessor::MacroState::setOverriddenMacros", NM="_ZN5clang12Preprocessor10MacroState19setOverriddenMacrosERS0_N4llvm8ArrayRefIPNS_11ModuleMacroEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10MacroState19setOverriddenMacrosERS0_N4llvm8ArrayRefIPNS_11ModuleMacroEEE")
    //</editor-fold>
    public void setOverriddenMacros(Preprocessor /*&*/ PP, 
                       ArrayRef<ModuleMacro /*P*/ > Overrides) {
      assert this != DEFAULT;
      ModuleMacroInfo /*P*/ Info = State.dyn_cast(ModuleMacroInfo /*P*/ .class);
      if (!(Info != null)) {
        if (Overrides.empty()) {
          return;
        }
        Info = /*FIXME:*//*new (PP.getPreprocessorAllocator())*/ new ModuleMacroInfo(State.get(MacroDirective /*P*/ .class));
        State.$assign_T1$C$R(ModuleMacroInfo /*P*/.class, Info);
      }
      Info.OverriddenMacros.clear();
      Info.OverriddenMacros.insert(Info.OverriddenMacros.end(), 
          Overrides.begin(), Overrides.end());
      Info.ActiveModuleMacrosGeneration = 0;
    }

    @Override public MacroState clone() {
      assert this == DEFAULT : "only empty default-value instance can be cloned";
      return new MacroState();
    }
    
    @Override public MacroState move() {
      return new MacroState(JD$Move.INSTANCE, this);
    }
    
    public static final MacroState DEFAULT = new MacroState();
    
    public String toString() {
      return "" + "State=" + State; // NOI18N
    }
  }

/// \brief Information about a submodule's preprocessor state.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SubmoduleState">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 524,
   FQN="clang::Preprocessor::SubmoduleState", NM="_ZN5clang12Preprocessor14SubmoduleStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14SubmoduleStateE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ SubmoduleState implements Destructors.ClassWithDestructor, NativeCloneable<SubmoduleState>, NativeMoveable<SubmoduleState> {
    /// The macros for the submodule.
    public DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState> Macros;
    /// The set of modules that are visible within the submodule.
    public VisibleModuleSet VisibleModules;
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SubmoduleState::~SubmoduleState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 528,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 524,
     FQN="clang::Preprocessor::SubmoduleState::~SubmoduleState", NM="_ZN5clang12Preprocessor14SubmoduleStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor14SubmoduleStateD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      assert this != DEFAULT;
      //START JDestroy
      VisibleModules.$destroy();
      Macros.$destroy();
      //END JDestroy
    }



    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SubmoduleState::SubmoduleState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 528,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 524,
     FQN="clang::Preprocessor::SubmoduleState::SubmoduleState", NM="_ZN5clang12Preprocessor14SubmoduleStateC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor14SubmoduleStateC1EOS1_")
    //</editor-fold>
    public /*inline*/ SubmoduleState(JD$Move _dparam, final SubmoduleState /*&&*/$Prm0) {
      assert $Prm0 != DEFAULT;
      // : Macros(static_cast<SubmoduleState &&>().Macros), VisibleModules(static_cast<SubmoduleState &&>().VisibleModules) 
      //START JInit
      this.Macros = new DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState>(JD$Move.INSTANCE, $Prm0.Macros);
      this.VisibleModules = new VisibleModuleSet(JD$Move.INSTANCE, $Prm0.VisibleModules);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SubmoduleState::SubmoduleState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 528,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 524,
     FQN="clang::Preprocessor::SubmoduleState::SubmoduleState", NM="_ZN5clang12Preprocessor14SubmoduleStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor14SubmoduleStateC1Ev")
    //</editor-fold>
    public /*inline*/ SubmoduleState() {
      /* : Macros(), VisibleModules()*/ 
      //START JInit
      this.Macros = new DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState>(IdentifierInfo.DMI$IdentifierInfoPtr, MacroState.DEFAULT);
      this.VisibleModules = new VisibleModuleSet();
      //END JInit
    }

    @Override public SubmoduleState clone() {
      assert this.Macros.empty() : "Only empty can be cloned as default-value";
      assert this.VisibleModules.getGeneration() == 0 : "Only empty can be cloned as default-value";
      return new SubmoduleState();
    }

    @Override public SubmoduleState move() {
      return new SubmoduleState(JD$Move.INSTANCE, this);
    }
    
    public static final SubmoduleState DEFAULT = new SubmoduleState();
    
    public String toString() {
      return "" + "Macros=" + Macros // NOI18N
                + ", VisibleModules=" + VisibleModules; // NOI18N
    }
  // FIXME: CounterValue?
  // FIXME: PragmaPushMacroInfo?
  }

/// \brief Information about a submodule that we're currently building.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::BuildingSubmoduleInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 508,
   FQN="clang::Preprocessor::BuildingSubmoduleInfo", NM="_ZN5clang12Preprocessor21BuildingSubmoduleInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21BuildingSubmoduleInfoE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ BuildingSubmoduleInfo implements NativePOD<BuildingSubmoduleInfo> {
    protected /*private*/ static final BuildingSubmoduleInfo DEFAULT = new BuildingSubmoduleInfo();
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::BuildingSubmoduleInfo::BuildingSubmoduleInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 510,
     FQN="clang::Preprocessor::BuildingSubmoduleInfo::BuildingSubmoduleInfo", NM="_ZN5clang12Preprocessor21BuildingSubmoduleInfoC1EPNS_6ModuleENS_14SourceLocationEPNS0_14SubmoduleStateEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21BuildingSubmoduleInfoC1EPNS_6ModuleENS_14SourceLocationEPNS0_14SubmoduleStateEj")
    //</editor-fold>
    public BuildingSubmoduleInfo(Module /*P*/ M, /*SourceLocation*/int ImportLoc, 
        SubmoduleState /*P*/ OuterSubmoduleState, 
        /*uint*/int OuterPendingModuleMacroNames) {
      /* : M(M), ImportLoc(ImportLoc), OuterSubmoduleState(OuterSubmoduleState), OuterPendingModuleMacroNames(OuterPendingModuleMacroNames)*/ 
      //START JInit
      this.M = M;
      this.ImportLoc = ImportLoc;
      this.OuterSubmoduleState = OuterSubmoduleState;
      this.OuterPendingModuleMacroNames = OuterPendingModuleMacroNames;
      //END JInit
    }

    // for values in collections
    protected /*private*/ BuildingSubmoduleInfo() {
      this.M = null;
      this.ImportLoc = SourceLocation.getInvalid();
      this.OuterSubmoduleState = null;
      this.OuterPendingModuleMacroNames = 0;
    }
    
    /// The module that we are building.
    public Module /*P*/ M;
    /// The location at which the module was included.
    public /*SourceLocation*/int ImportLoc;
    /// The previous SubmoduleState.
    public SubmoduleState /*P*/ OuterSubmoduleState;
    /// The number of pending module macro names when we started building this.
    public /*uint*/int OuterPendingModuleMacroNames;
    
    public String toString() {
      return "" + "M=" + M // NOI18N
                + ", ImportLoc=" + ImportLoc // NOI18N
                + ", OuterSubmoduleState=" + OuterSubmoduleState // NOI18N
                + ", OuterPendingModuleMacroNames=" + OuterPendingModuleMacroNames; // NOI18N
    }

    @Override
    public BuildingSubmoduleInfo $assign(BuildingSubmoduleInfo value) {
      this.M = value.M;
      this.ImportLoc = value.ImportLoc;
      this.OuterSubmoduleState = value.OuterSubmoduleState;
      this.OuterPendingModuleMacroNames = value.OuterPendingModuleMacroNames;
      return this;
    }

    @Override
    public BuildingSubmoduleInfo clone() {
      return new BuildingSubmoduleInfo(this.M, this.ImportLoc, this.OuterSubmoduleState, this.OuterPendingModuleMacroNames);
    }

    @Override
    public boolean $eq(BuildingSubmoduleInfo other) {
      return this.M == other.M && this.OuterSubmoduleState == other.OuterSubmoduleState 
              && this.OuterPendingModuleMacroNames == other.OuterPendingModuleMacroNames && this.ImportLoc == other.ImportLoc;
    }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroInfoChain">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 635,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 628,
   FQN="clang::Preprocessor::MacroInfoChain", NM="_ZN5clang12Preprocessor14MacroInfoChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14MacroInfoChainE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ MacroInfoChain extends MacroInfo implements Destructors.ClassWithDestructor {
    //JAVA changed class to endent MacroInfo and removed field
    // because in code the instance of DeserializedMacroInfoChain is casted to MacroInfo and vise versa
    // public MacroInfo MI; extends MacroInfo    
    public MacroInfoChain /*P*/ Next;

    public MacroInfoChain(/*SourceLocation*/int L) {
      super(L);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MacroInfoChain::~MacroInfoChain">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 635,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 628,
     FQN="clang::Preprocessor::MacroInfoChain::~MacroInfoChain", NM="_ZN5clang12Preprocessor14MacroInfoChainD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor14MacroInfoChainD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      /*MI*/super.$destroy();
      //END JDestroy
    }


    
    public String toString() {
      return "" + "MI=" + /*MI*/super.toString() // NOI18N
                + ", Next=" + Next; // NOI18N
    }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DeserializedMacroInfoChain">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 644,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 637,
   FQN="clang::Preprocessor::DeserializedMacroInfoChain", NM="_ZN5clang12Preprocessor26DeserializedMacroInfoChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor26DeserializedMacroInfoChainE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ DeserializedMacroInfoChain extends MacroInfo implements Destructors.ClassWithDestructor {
    //JAVA changed class to endent MacroInfo and removed field
    // because in code the instance of DeserializedMacroInfoChain is casted to MacroInfo and vise versa
    // public MacroInfo MI; extends MacroInfo
    public /*uint*/int OwningModuleID; // MUST be immediately after the MacroInfo object
    // so it can be accessed by MacroInfo::getOwningModuleID().
    public DeserializedMacroInfoChain /*P*/ Next;
    //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DeserializedMacroInfoChain::~DeserializedMacroInfoChain">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 644,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 637,
     FQN="clang::Preprocessor::DeserializedMacroInfoChain::~DeserializedMacroInfoChain", NM="_ZN5clang12Preprocessor26DeserializedMacroInfoChainD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor26DeserializedMacroInfoChainD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      /*MI*/super.$destroy();
      //END JDestroy
    }


    
    public String toString() {
      return "" + "MI=" + /*MI*/super.toString() // NOI18N
                + ", OwningModuleID=" + OwningModuleID // NOI18N
                + ", Next=" + Next; // NOI18N
    }
  }
/*class ResetMacroExpansionHelper*/ /*NO BODY FOUND*/
} // END OF class Preprocessor_NestedClasses
