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

package org.clang.parse.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import org.llvm.mc.mcparser.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 38,
 FQN="(anonymous namespace)::ClangAsmParserCallback", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallbackE")
//</editor-fold>
public class ClangAsmParserCallback extends /*public*/ MCAsmParserSemaCallback implements Destructors.ClassWithDestructor {
  private Parser /*&*/ TheParser;
  private SourceLocation AsmLoc;
  private StringRef AsmString;
  
  /// The tokens we streamed into AsmString and handed off to MC.
  private ArrayRefToken AsmToks;
  
  /// The offset of each token in AsmToks within AsmString.
  private ArrayRefUInt AsmTokOffsets;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::ClangAsmParserCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 50,
   FQN="(anonymous namespace)::ClangAsmParserCallback::ClangAsmParserCallback", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallbackC1ERN5clang6ParserENS1_14SourceLocationEN4llvm9StringRefENS5_8ArrayRefINS1_5TokenEEENS7_IjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallbackC1ERN5clang6ParserENS1_14SourceLocationEN4llvm9StringRefENS5_8ArrayRefINS1_5TokenEEENS7_IjEE")
  //</editor-fold>
  public ClangAsmParserCallback(Parser /*&*/ P, SourceLocation Loc, StringRef AsmString, 
      ArrayRefToken Toks, ArrayRefUInt Offsets) {
    // : MCAsmParserSemaCallback(), TheParser(P), AsmLoc(Loc), AsmString(AsmString), AsmToks(Toks), AsmTokOffsets(Offsets) 
    //START JInit
    super();
    this./*&*/TheParser=/*&*/P;
    this.AsmLoc = new SourceLocation(Loc);
    this.AsmString = new StringRef(AsmString);
    this.AsmToks = new ArrayRefToken(Toks);
    this.AsmTokOffsets = new ArrayRefUInt(Offsets);
    //END JInit
    assert (AsmToks.size() == AsmTokOffsets.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 57,
   FQN="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmIdentifier", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback25LookupInlineAsmIdentifierERN4llvm9StringRefERNS1_23InlineAsmIdentifierInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback25LookupInlineAsmIdentifierERN4llvm9StringRefERNS1_23InlineAsmIdentifierInfoEb")
  //</editor-fold>
  @Override public Object/*void P*/ LookupInlineAsmIdentifier(StringRef /*&*/ LineBuf, 
                           InlineAsmIdentifierInfo /*&*/ Info, 
                           boolean IsUnevaluatedContext)/* override*/ {
    // Collect the desired tokens.
    SmallVectorToken LineToks/*J*/= new SmallVectorToken(16, /*PERF: new Token()*/null);
    /*const*/type$ptr<Token> /*P*/ FirstOrigToken = create_type$null$ptr();
    findTokensForString(new StringRef(LineBuf), LineToks, FirstOrigToken);
    
    /*uint*/uint$ref NumConsumedToks = create_uint$ref();
    ActionResultTTrue<Expr /*P*/ > Result = TheParser.ParseMSAsmIdentifier(LineToks, NumConsumedToks, $AddrOf(Info), IsUnevaluatedContext);
    
    // If we consumed the entire line, tell MC that.
    // Also do this if we consumed nothing as a way of reporting failure.
    if (NumConsumedToks.$deref() == 0 || NumConsumedToks.$deref() == LineToks.size()) {

      // By not modifying LineBuf, we're implicitly consuming it all.

      // Otherwise, consume up to the original tokens.
    } else {
      assert ((FirstOrigToken != null)) : "not using original tokens?";
      
      // Since we're using original tokens, apply that offset.
      assert ($eq_SourceLocation$C(FirstOrigToken.$at(NumConsumedToks).getLocation(), LineToks.$at(NumConsumedToks).getLocation()));
      /*uint*/int FirstIndex = FirstOrigToken.$sub(AsmToks.begin());
      /*uint*/int LastIndex = FirstIndex + NumConsumedToks.$deref() - 1;
      
      // The total length we've consumed is the relative offset
      // of the last token we consumed plus its length.
      /*uint*/int TotalOffset = (AsmTokOffsets.$at(LastIndex) + AsmToks.$at(LastIndex).getLength()
         - AsmTokOffsets.$at(FirstIndex));
      LineBuf.$assignMove(LineBuf.substr(0, TotalOffset));
    }
    
    // Initialize the "decl" with the lookup result.
    Info.OpDecl = (reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Result.get())));
    return Info.OpDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 97,
   FQN="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmLabel", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback20LookupInlineAsmLabelEN4llvm9StringRefERNS1_9SourceMgrENS1_5SMLocEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback20LookupInlineAsmLabelEN4llvm9StringRefERNS1_9SourceMgrENS1_5SMLocEb")
  //</editor-fold>
  @Override public StringRef LookupInlineAsmLabel(StringRef Identifier, SourceMgr /*&*/ LSM, 
                      SMLoc Location, 
                      boolean Create)/* override*/ {
    SourceLocation Loc = translateLocation(LSM, new SMLoc(Location));
    LabelDecl /*P*/ Label = TheParser.getActions().GetOrCreateMSAsmLabel(new StringRef(Identifier), new SourceLocation(Loc), Create);
    return Label.getMSAsmLabel();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 106,
   FQN="(anonymous namespace)::ClangAsmParserCallback::LookupInlineAsmField", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback20LookupInlineAsmFieldEN4llvm9StringRefES2_Rj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback20LookupInlineAsmFieldEN4llvm9StringRefES2_Rj")
  //</editor-fold>
  @Override public boolean LookupInlineAsmField(StringRef Base, StringRef Member, 
                      uint$ref/*uint &*/ Offset)/* override*/ {
    return TheParser.getActions().LookupInlineAsmField(new StringRef(Base), new StringRef(Member), Offset, 
        new SourceLocation(AsmLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::DiagHandlerCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 112,
   FQN="(anonymous namespace)::ClangAsmParserCallback::DiagHandlerCallback", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback19DiagHandlerCallbackERKN4llvm12SMDiagnosticEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback19DiagHandlerCallbackERKN4llvm12SMDiagnosticEPv")
  //</editor-fold>
  public static void DiagHandlerCallback(/*const*/ SMDiagnostic /*&*/ D, Object/*void P*/ Context) {
    ((ClangAsmParserCallback /*P*/ )Context).handleDiagnostic(D);
  }

/*private:*/
  /// Collect the appropriate tokens for the given string.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::findTokensForString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed assign to pointer ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 118,
   FQN="(anonymous namespace)::ClangAsmParserCallback::findTokensForString", NM="_ZNK12_GLOBAL__N_122ClangAsmParserCallback19findTokensForStringEN4llvm9StringRefERNS1_15SmallVectorImplIN5clang5TokenEEERPKS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZNK12_GLOBAL__N_122ClangAsmParserCallback19findTokensForStringEN4llvm9StringRefERNS1_15SmallVectorImplIN5clang5TokenEEERPKS5_")
  //</editor-fold>
  private void findTokensForString(StringRef Str, SmallVectorToken/*&*/ TempToks, 
                     final/*const*/type$ptr<Token> /*P*//*&*/ FirstOrigToken) /*const*/ {
    // For now, assert that the string we're working with is a substring
    // of what we gave to MC.  This lets us use the original tokens.
    assert (!new std.less$char$ptr().$call(Str.begin(), AsmString.begin()) && !new std.less$char$ptr().$call(AsmString.end(), Str.end()));
    
    // Try to find a token whose offset matches the first token.
    /*uint*/int FirstCharOffset = Str.begin().$sub(AsmString.begin());
    /*const*/uint$ptr/*uint P*/ FirstTokOffset = $tryClone(std.lower_bound_uint(AsmTokOffsets.begin(), AsmTokOffsets.end(), FirstCharOffset));
    
    // For now, assert that the start of the string exactly
    // corresponds to the start of a token.
    assert (FirstTokOffset.$star() == FirstCharOffset);
    
    // Use all the original tokens for this line.  (We assume the
    // end of the line corresponds cleanly to a token break.)
    /*uint*/int FirstTokIndex = FirstTokOffset.$sub(AsmTokOffsets.begin());
    // JAVA: fixed assignment in the line below
    FirstOrigToken.$assign($AddrOf(AsmToks.ptr$at(FirstTokIndex)));
    /*uint*/int LastCharOffset = Str.end().$sub(AsmString.begin());
    for (/*uint*/int i = FirstTokIndex, e = AsmTokOffsets.size(); i != e; ++i) {
      if ($greatereq_uint(AsmTokOffsets.$at(i), LastCharOffset)) {
        break;
      }
      TempToks.push_back(AsmToks.$at(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::translateLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 146,
   FQN="(anonymous namespace)::ClangAsmParserCallback::translateLocation", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback17translateLocationERKN4llvm9SourceMgrENS1_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback17translateLocationERKN4llvm9SourceMgrENS1_5SMLocE")
  //</editor-fold>
  private SourceLocation translateLocation(/*const*/ SourceMgr /*&*/ LSM, SMLoc SMLoc) {
    // Compute an offset into the inline asm buffer.
    // FIXME: This isn't right if .macro is involved (but hopefully, no
    // real-world code does that).
    /*const*/ MemoryBuffer /*P*/ LBuf = LSM.getMemoryBuffer(LSM.FindBufferContainingLoc(new SMLoc(SMLoc)));
    /*uint*/int Offset = SMLoc.getPointer().$sub(LBuf.getBufferStart());
    
    // Figure out which token that offset points into.
    /*const*/uint$ptr/*uint P*/ TokOffsetPtr = $tryClone(std.lower_bound_uint(AsmTokOffsets.begin(), AsmTokOffsets.end(), Offset));
    /*uint*/int TokIndex = TokOffsetPtr.$sub(AsmTokOffsets.begin());
    /*uint*/int TokOffset = TokOffsetPtr.$star();
    
    // If we come up with an answer which seems sane, use it; otherwise,
    // just point at the __asm keyword.
    // FIXME: Assert the answer is sane once we handle .macro correctly.
    SourceLocation Loc = new SourceLocation(AsmLoc);
    if ($less_uint(TokIndex, AsmToks.size())) {
      /*const*/ Token /*&*/ Tok = AsmToks.$at(TokIndex);
      Loc.$assignMove(Tok.getLocation());
      Loc.$assignMove(Loc.getLocWithOffset(Offset - TokOffset));
    }
    return Loc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::handleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 172,
   FQN="(anonymous namespace)::ClangAsmParserCallback::handleDiagnostic", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallback16handleDiagnosticERKN4llvm12SMDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallback16handleDiagnosticERKN4llvm12SMDiagnosticE")
  //</editor-fold>
  private void handleDiagnostic(/*const*/ SMDiagnostic /*&*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ SourceMgr /*&*/ LSM = $Deref(D.getSourceMgr());
      SourceLocation Loc = translateLocation(LSM, D.getLoc());
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(TheParser.Diag(new SourceLocation(Loc), diag.err_inline_ms_asm_parsing)), D.getMessage()));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangAsmParserCallback::~ClangAsmParserCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 38,
   FQN="(anonymous namespace)::ClangAsmParserCallback::~ClangAsmParserCallback", NM="_ZN12_GLOBAL__N_122ClangAsmParserCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN12_GLOBAL__N_122ClangAsmParserCallbackD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TheParser=" + TheParser // NOI18N
              + ", AsmLoc=" + AsmLoc // NOI18N
              + ", AsmString=" + AsmString // NOI18N
              + ", AsmToks=" + AsmToks // NOI18N
              + ", AsmTokOffsets=" + AsmTokOffsets // NOI18N
              + super.toString(); // NOI18N
  }
}
