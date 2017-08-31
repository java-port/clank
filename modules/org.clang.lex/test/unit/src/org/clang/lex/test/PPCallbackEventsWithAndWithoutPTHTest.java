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

package org.clang.lex.test;

import java.util.ArrayList;
import java.util.List;
import org.clang.basic.*;
import static org.clang.basic.SrcMgr.CharacteristicKind.C_User;
import static org.clang.lex.PPCallbacks.ConditionValueKind.CVK_False;
import static org.clang.lex.PPCallbacks.ConditionValueKind.CVK_NotEvaluated;
import static org.clang.lex.PPCallbacks.ConditionValueKind.CVK_True;
import static org.clang.lex.PPCallbacks.FileChangeReason.EnterFile;
import static org.clang.lex.PPCallbacks.FileChangeReason.ExitFile;
import org.clang.lex.PreprocessorOptions;
import org.clang.lex.Token;
import org.clang.lex.test.PPCallbackEventsTracker.*;
import static org.clang.lex.test.PPCallbackEventsTracker.*;
import org.clank.java.*;
import org.clank.support.*;
import org.junit.Test;

// PPCallbacks test fixture.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest")
//</editor-fold>
public class PPCallbackEventsWithAndWithoutPTHTest extends /*public*/ /*::*/PPCallbackEventsTestBase implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="harness">
  static {
    System.setProperty("use.pth.driver.in.test", "false");
    System.setProperty("clank.pth.cache.all", "true");
    System.setProperty("clank.pth.keep.comments", "true");
    System.setProperty("clank.pth.keep.incomplete.token.state", "true");
  }
  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 112,
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::PPCallbacksTest")
  //</editor-fold>
  public PPCallbackEventsWithAndWithoutPTHTest() {
    /* : ::Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), DiagOpts(new DiagnosticOptions()), Diags(DiagID, DiagOpts.getPtr(), new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), TargetOpts(), Target()*/
    //START JInit
    super(TestState.Successful);
  }

  @Override
  public void startUp() {
    System.setProperty("clank.pth.keep.comments", "true");
    System.setProperty("use.pth.driver.in.test", "false");
    super.startUp();
  }
  
  
  // Run lexer over SourceText and collect FilenameRange from
  // the InclusionDirective callback.
  // for dumping 'expected' could be PRINT_EVENTS_FROM_NON_PTH_RUN or GATHER_EVENTS_FROM_NON_PTH_RUN
  // 'ExpectedTokens' could be PRINT_TOKENS
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::InclusionDirectiveFilenameRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 157,
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::InclusionDirectiveFilenameRange")
  //</editor-fold>
  private void RunPreprocessorWithAndWithoutPTH(List<PPCallbackEvent> expected, /*const*/String/*char P*/ __SourceText,
          std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens) {
    RunPreprocessorWithAndWithoutPTH(expected, __SourceText, ExpectedTokens, null, "", "", false);
  }
  private void RunPreprocessorWithAndWithoutPTH(List<PPCallbackEvent> expected, /*const*/String/*char P*/ __SourceText,
          std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens, boolean keepComments) {
    RunPreprocessorWithAndWithoutPTH(expected, __SourceText, ExpectedTokens, new PreprocessorInitializer(keepComments), "", "", false);
  }
  private void RunPreprocessorWithAndWithoutPTH(List<PPCallbackEvent> expected, /*const*/String/*char P*/ __SourceText,
          std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens,
          PreprocessorInitializer PPInitializer,
          /*const*/String/*char P*/ __HeaderPath, String __HeaderText, boolean SystemHeader) {
    assert NativeTrace.USE_PTH_DRIVER_IN_TEST == false : "must be disabled for this Suite";
    PPCallbackEventsTracker noPTH = super.RunPreprocessor(__SourceText, false, ExpectedTokens, PPInitializer, __HeaderPath, __HeaderText, SystemHeader);
    PPCallbackEventsTracker withPTH = super.RunPreprocessor(__SourceText, true, ExpectedTokens, PPInitializer, __HeaderPath, __HeaderText, SystemHeader);
    
    if (PRINT_EVENTS_FROM_NON_PTH_RUN == expected) {
      // generate expected events in output
      dumpEvents(noPTH.getEvents());
      return;
    }
    if (GATHER_EVENTS_FROM_NON_PTH_RUN == expected) {
      expected = noPTH.getEvents();
      if (false) {
        System.out.println("");
        System.out.println(getTestMethodName());
        System.out.println(noPTH.toString());
        return;
      }
    } else {
      PPCallbackEventsTracker.ASSERT_EQ(getTestMethodName(), expected, noPTH);
    }
    PPCallbackEventsTracker.ASSERT_EQ(getTestMethodName(), expected, withPTH);
  }
  
  private void dumpEvents(List<PPCallbackEvent> expected) {
    for (PPCallbackEvent event : expected) {
      switch (event.Kind) {
        case FILE_CHANGED: {
          PPFileChangedEvent e = (PPFileChangedEvent) event;
          String prev;
          if (e.PrevFID.isInvalid()) {
            prev = "FileID.getInvalidID()";
          } else {
            prev = ""+e.PrevFID.$ID();
          }
          System.out.println("    ExpectedEvents.add(FILE_CHANGED(" + e.ChangedToLoc.getRawEncoding() + ", " + e.ChangeReason + ", " + e.FileType + ", " + prev + "));");
          break;
        }
        case IF:{
          PPConditionEvent e = (PPConditionEvent) event;
          System.out.println("    ExpectedEvents.add(IF("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.DirectiveTokenLoc.getRawEncoding()+
                  ", new SourceRange("+e.ConditionRange.$getBegin()+" ,"+e.ConditionRange.$getEnd()+"), "+e.ConditionValue+"));");
          break;}
        case IFDEF:{
          PPIfdefIfndefConditionEvent e = (PPIfdefIfndefConditionEvent) event;
          System.out.println("    ExpectedEvents.add(IFDEF("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+","+e.DirectiveTokenLoc.getRawEncoding()+", "+
                  e.ConditionRange.$getBegin()+", "+e.ConditionValue+"));");
          break;}
        case IFNDEF:{
          PPIfdefIfndefConditionEvent e = (PPIfdefIfndefConditionEvent) event;
          System.out.println("    ExpectedEvents.add(IFNDEF("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+","+e.DirectiveTokenLoc.getRawEncoding()+", "+
                  e.ConditionRange.$getBegin()+", "+e.ConditionValue+"));");
          break;}
        case ELIF:{
          PPConditionEvent e = (PPConditionEvent) event;
          System.out.println("    ExpectedEvents.add(ELIF("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.DirectiveTokenLoc.getRawEncoding()+
                  ", new SourceRange("+e.ConditionRange.$getBegin()+" ,"+e.ConditionRange.$getEnd()+"), "+e.ConditionValue+", "+e.MatchingIfDirectiveLoc.getRawEncoding()+"));");
          break;}
        case ELSE:{
          PPConditionEvent e = (PPConditionEvent) event;
          System.out.println("    ExpectedEvents.add(ELSE("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.DirectiveTokenLoc.getRawEncoding()+
                  ", "+e.MatchingIfDirectiveLoc.getRawEncoding()+"));");
          break;}
        case ENDIF:{
          PPConditionEvent e = (PPConditionEvent) event;
          System.out.println("    ExpectedEvents.add(ENDIF("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.DirectiveTokenLoc.getRawEncoding()+
                  ", "+e.MatchingIfDirectiveLoc.getRawEncoding()+"));");
          break;}
        case SOURCE_RANGE_SKIPPED:{
          PPSourceRangeSkippedCallbackEvent e = (PPSourceRangeSkippedCallbackEvent) event;
          System.out.println("    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange("+e.SkippedRange.$getBegin()+" ,"+e.SkippedRange.$getEnd()+")));");
          break;}
        case PP_IS_DEFINED_EXPRESSION:{
          PPMacroExpandsIsDefinedEvent e = (PPMacroExpandsIsDefinedEvent) event;
          System.out.println("    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION("+e.UsedMacroTokLoc.getRawEncoding()+", \""+e.UsedMacroName.toJavaString()+"\", "+
                  e.MDHashLoc.getRawEncoding()+", "+e.MDFunctionLike+", "+e.MDNumArgs+", new SourceRange("+e.UsedMacroRange.$getBegin()+", "+e.UsedMacroRange.$getEnd()+")));");
          break;}
        case MACRO_DEFINED:{
          PPMacroDefinedUndefinedEvent e = (PPMacroDefinedUndefinedEvent) event;
          System.out.println("    ExpectedEvents.add(MACRO_DEFINED("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.MacroNameTokLoc.getRawEncoding()+
                  ", \""+e.MacroName.toJavaString()+"\", "+e.MDHashLoc.getRawEncoding()+", "+e.MDFunctionLike+", "+e.MDNumArgs+"));");
          break;}
        case MACRO_UNDEFINED:{
          PPMacroDefinedUndefinedEvent e = (PPMacroDefinedUndefinedEvent) event;
          System.out.println("    ExpectedEvents.add(MACRO_UNDEFINED("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.MacroNameTokLoc.getRawEncoding()+
                  ", \""+e.MacroName.toJavaString()+"\", "+e.MDHashLoc.getRawEncoding()+", "+e.MDFunctionLike+", "+e.MDNumArgs+"));");
          break;}
        case MACRO_EXPANDS:{
          PPMacroExpandsIsDefinedEvent e = (PPMacroExpandsIsDefinedEvent) event;
          System.out.println("    ExpectedEvents.add(MACRO_EXPANDS("+e.UsedMacroTokLoc.getRawEncoding()+", \""+e.UsedMacroName.toJavaString()+"\", "+
                  e.MDHashLoc.getRawEncoding()+", "+e.MDFunctionLike+", "+e.MDNumArgs+", new SourceRange("+e.UsedMacroRange.$getBegin()+", "+e.UsedMacroRange.$getEnd()+"), "+e.NumUsedArgs+"));");
          break;}
        case USER_DIAGNOSTICS:{
          PPUserDiagnosticEvent e = (PPUserDiagnosticEvent)event;
          System.out.println("    ExpectedEvents.add(USER_DIAGNOSTICS("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+
                  ", "+e.DirectiveTokenLoc.getRawEncoding()+", \""+e.Message.toJavaString().replace("\"", "\\\"")+"\", "+e.Warning+"));");
          break;}
        case END_OF_MAIN_FILE:{
          System.out.println("    ExpectedEvents.add(END_OF_MAIN_FILE());");
          break;}
        case INCLUSION_DIRECTIVE:{
          PPInclusionDirectiveEvent e = (PPInclusionDirectiveEvent) event;
          if (e.File == null) {
            System.out.println("    ExpectedEvents.add(INCLUSION_DIRECTIVE("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.IncludeTok.$getLocation()+
                    ", \""+e.FileName.toJavaString()+"\", "+e.IsAngled+", new CharSourceRange("+e.FilenameRange.$getBegin()+", "+e.FilenameRange.$getEnd()+", "+e.FilenameRange.isTokenRange()+
                    "), null, \""+e.SearchPath.toJavaString()+"\", \""+e.RelativePath.toJavaString()+"\", null));");
          } else {
            System.out.println("    ExpectedEvents.add(INCLUSION_DIRECTIVE("+e.HashLoc.getRawEncoding()+", "+e.EodLoc.getRawEncoding()+", "+e.IncludeTok.$getLocation()+
                    ", \""+e.FileName.toJavaString()+"\", "+e.IsAngled+", new CharSourceRange("+e.FilenameRange.$getBegin()+", "+e.FilenameRange.$getEnd()+", "+e.FilenameRange.isTokenRange()+
                    "), \""+e.FileEntryName+"\", \""+e.SearchPath.toJavaString()+"\", \""+e.RelativePath.toJavaString()+"\", null));");
          }
          break;}
        case FILE_NOT_FOUND:{
          PPFileNotFoundEvent e = (PPFileNotFoundEvent) event;
          System.out.println("    ExpectedEvents.add(FILE_NOT_FOUND(\""+e.NotFoundFileName.toJavaString()+"\", "+e.NumSearchDirs+", "+e.SearchedFromIndex+"));");
          break;}
        case FILE_SKIPPED:{
          PPFileSkippedEvent e = (PPFileSkippedEvent) event;
          System.out.println("    ExpectedEvents.add(FILE_SKIPPED(\""+e.SkippedFileName.toJavaString()+"\", "+e.SkippedFileTokenLoc.getRawEncoding()+", "+e.FileType+"));");
          break;}
        case FILE_GUARDED:{
          PPFileDetectedAsGuarded e = (PPFileDetectedAsGuarded) event;
          System.out.println("    ExpectedEvents.add(FILE_GUARDED(\""+e.GuardedFileName.toJavaString()+"\", \""+e.CheckedGuardName.toJavaString()+"\", "+e.CheckGuardMacroLoc.getRawEncoding()+
                  ", \""+e.DefinedGuardName.toJavaString()+"\", "+e.DefinedGuardMacroLoc.getRawEncoding()+"));");
          break;}
        case DEEP_FILE_INCLUSION:{
          System.out.println("    ExpectedEvents.add(DEEP_FILE_INCLUSION());");
          break;}
        case MODULE_IMPORT:
        default:
          throw new UnsupportedOperationException();
      }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::~PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::~PPCallbacksTest")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
  //</editor-fold>
  
  @Test
  public void Check_LineCommentFollowedByStar() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"//* incorrect interpretation of start-block comment\n" + 
"#define A B\n" +
"int A;\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(101, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(54, 65, 62, "A", 54, false, 0));
    ExpectedEvents.add(MACRO_EXPANDS(70, "A", 54, false, 0, new SourceRange(70, 70), -1));    
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, true);
  }
  
  @Test
  public void Check_If_True_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"/*#include \"a.h\"*/\n" + 
"#if 1\n" +
"/*alive comment*/\n" +            
"int alive;\n" +
"#elif 0\n" +
"/*dead comment 1*/\n" +             
"#else\n" +
"/*dead comment 2*/\n" +
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(143, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(IF(21, 26, 22, new SourceRange(24 ,27), CVK_True));
    ExpectedEvents.add(ELIF(56, 63, 57, new SourceRange(61 ,64), CVK_NotEvaluated, 22));
    ExpectedEvents.add(ELSE(83, 88, 84, 22));
    ExpectedEvents.add(ENDIF(108, 114, 109, 22));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(57 ,109)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_If_False_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#include \"unresolved.h\" // expected-error {{'unresolved.h' file not found}}\n" + 
"#if 0\n" +
"/*dead comment*/\n" +
"double dead;\n" +
"#elif 1\n" +
"/*alive comment*/\n" +             
"#else\n" +
"/*dead comment 2*/\n" +            
"#endif\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(173, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(FILE_NOT_FOUND("unresolved.h", 0, 0));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(2, 77, 3, "unresolved.h", false, new CharSourceRange(11, 25, false), null, "", "", null));
    ExpectedEvents.add(IF(78, 83, 79, new SourceRange(81 ,84), CVK_False));
    ExpectedEvents.add(ELIF(114, 121, 115, new SourceRange(119 ,122), CVK_True, 79));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(141 ,166)));
    ExpectedEvents.add(ELSE(140, 145, 141, 79));
    ExpectedEvents.add(ENDIF(165, 171, 166, 79));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(141 ,166)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void Check_Incomplete_Char_Tokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =    
"// expected-warning@+6 {{missing terminating ' character}}\n" +            
"// expected-warning@+6 {{empty character constant}}\n" +            
"// expected-warning@+6 {{missing terminating ' character}}\n" +            
"// expected-warning@+6 {{missing terminating ' character}}\n" +            
"// expected-warning@+6 {{missing terminating ' character}}\n" +            
"// expected-warning@+6 {{missing terminating ' character}}\n" +            
"'Incomplete Char\n" +
"''\n" +
"L'a\n" + 
"u8'b\n" + 
"u'c\n" + 
"U'd\n";            
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.char_constant);
    ExpectedTokens.push_back(tok.TokenKind.char_constant);
    ExpectedTokens.push_back(tok.TokenKind.wide_char_constant);    
    ExpectedTokens.push_back(tok.TokenKind.utf8_char_constant);
    ExpectedTokens.push_back(tok.TokenKind.utf16_char_constant);
    ExpectedTokens.push_back(tok.TokenKind.utf32_char_constant);
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(387, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void Check_Incomplete_String_Tokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =            
"// expected-warning@+5 {{missing terminating '\"' character}}\n" +            
"// expected-warning@+5 {{missing terminating '\"' character}}\n" +            
"// expected-warning@+5 {{missing terminating '\"' character}}\n" +            
"// expected-warning@+5 {{missing terminating '\"' character}}\n" +            
"// expected-warning@+5 {{missing terminating '\"' character}}\n" +            
"\"foo\n" + 
"L\"foo\n" +
"u8\"foo\n" + 
"u\"foo\n" + 
"U\"foo\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.string_literal);
    ExpectedTokens.push_back(tok.TokenKind.wide_string_literal);
    ExpectedTokens.push_back(tok.TokenKind.utf8_string_literal);
    ExpectedTokens.push_back(tok.TokenKind.utf16_string_literal);
    ExpectedTokens.push_back(tok.TokenKind.utf32_string_literal);
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(338, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void Check_User_Diagnostic() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =            
"// expected-warning@+3 {{First Warning}}\n" +
"// expected-error@+5 {{Error message}}\n" +
"// expected-warning@+6 {{Second Warning}}\n" +
"#warning \"First Warning\"\n" + 
"int alive;\n" +             
"\n" + 
"#error \"Error message\"\n" +             
"double dead;\n" +             
"#warning \"Second Warning\"\n" + 
"\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    ExpectedTokens.push_back(tok.TokenKind.kw_double);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(225, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(USER_DIAGNOSTICS(124, 148, 125, "\"First Warning\"", true));
    ExpectedEvents.add(USER_DIAGNOSTICS(161, 183, 162, "\"Error message\"", false));
    ExpectedEvents.add(USER_DIAGNOSTICS(197, 222, 198, "\"Second Warning\"", true));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_User_Diagnostic_With_Tab() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =            
"// expected-error@+1 {{qwe}}\n" +
"#			error \"qwe\"\t\n";
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(49, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(USER_DIAGNOSTICS(31, 47, 35, "\"qwe\"	", false));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, null);
  }

  @Test
  public void Check_User_Diagnostic_Trigrapth_And_Different_Tokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =            
"#\n" +
"%:/*empty*/\n" +
"\n" +
"void foo() {\n" +
"// expected-warning@+1 {{ssss1  /*comment*/}}\n" +
"#warning    ssss1  /*comment*/  \n" +
"}\n" +
"\n" +
"%:\n" +
"#/*empty*/\n" +
"\n" +
"void boo() {\n" +
"// expected-warning@+1 {{(  ssss2 ) [}}\n" +
"%:warning (  ssss2 ) [     \n" +
"\n" +
"}\n" +
"";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_void);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);
    ExpectedTokens.push_back(tok.TokenKind.l_brace);
    ExpectedTokens.push_back(tok.TokenKind.r_brace);
    ExpectedTokens.push_back(tok.TokenKind.kw_void);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);
    ExpectedTokens.push_back(tok.TokenKind.l_brace);
    ExpectedTokens.push_back(tok.TokenKind.r_brace);
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(212, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(USER_DIAGNOSTICS(76, 108, 77, "ssss1  /*comment*/  ", true));
    ExpectedEvents.add(USER_DIAGNOSTICS(180, 207, 182, "(  ssss2 ) [     ", true));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void Check_Defined_Expanded_Undefined_Macro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =            
"// expected-no-diagnostics\n" +
"#define A alive\n" + 
"#undef AA\n" +
"#define AA(x) int x\n" + 
"AA(A);\n" +             
"#undef AA\n" +             
"\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(94, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(29, 44, 37, "A", 29, false, 0));
    ExpectedEvents.add(MACRO_UNDEFINED(45, 54, 52, "AA", 0, false, -1));
    ExpectedEvents.add(MACRO_DEFINED(55, 74, 63, "AA", 55, true, 1));
    ExpectedEvents.add(MACRO_EXPANDS(75, "AA", 55, true, 1, new SourceRange(75, 79), 2));
    ExpectedEvents.add(MACRO_EXPANDS(78, "A", 29, false, 0, new SourceRange(78, 78), -1));
    ExpectedEvents.add(MACRO_UNDEFINED(82, 91, 89, "AA", 55, true, 1));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_If_Defined_True_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =        
"#define A\n" + 
"#if defined A\n" +
"  #if defined (A)\n" +
"    int alive;\n" +
"    /*alive comment*/\n" +
"  #elif 0\n" +
"    /*dead comment 1*/\n" +             
"  #else\n" +
"    /*dead comment 2*/\n" +            
"  #endif\n" +                 
"#else\n" +
" /*dead comment 3*/\n" +                  
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(215, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(24, "A", 2, false, 0, new SourceRange(16, 25)));
    ExpectedEvents.add(IF(12, 25, 13, new SourceRange(15 ,26), CVK_True));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(41, "A", 2, false, 0, new SourceRange(32, 43)));
    ExpectedEvents.add(IF(28, 43, 29, new SourceRange(31 ,44), CVK_True));
    ExpectedEvents.add(ELIF(83, 90, 84, new SourceRange(88 ,91), CVK_NotEvaluated, 29));
    ExpectedEvents.add(ELSE(116, 121, 117, 29));
    ExpectedEvents.add(ENDIF(147, 153, 148, 29));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(155 ,181)));
    ExpectedEvents.add(ELSE(154, 159, 155, 13));
    ExpectedEvents.add(ENDIF(180, 186, 181, 13));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(155 ,181)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_If_Defined_False_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =  
"#define A\n" + 
"#if defined B\n" +
"int dead;\n" +
"/*dead comment*/\n" +    
"#elif 0\n" +
"/*dead comment 1*/\n" +             
"#else\n" +
"/*alive comment 1*/\n" +                  
"#endif\n" +
"\n" +            
"#if defined (B)\n" +
"int dead;\n" +
"/*dead comment*/\n" +     
"#else\n" +
"/*alive comment 2*/\n" +               
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(218, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(24, "B", 0, false, -1, new SourceRange(16, 25)));
    ExpectedEvents.add(IF(12, 25, 13, new SourceRange(15 ,26), CVK_False));
    ExpectedEvents.add(ELIF(53, 60, 54, new SourceRange(58 ,61), CVK_False, 13));
    ExpectedEvents.add(ELSE(80, 85, 81, 13));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(115 ,158)));
    ExpectedEvents.add(ENDIF(106, 112, 107, 13));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(127, "B", 0, false, -1, new SourceRange(118, 129)));
    ExpectedEvents.add(IF(114, 129, 115, new SourceRange(117 ,130), CVK_False));
    ExpectedEvents.add(ELSE(157, 162, 158, 115));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(115 ,158)));
    ExpectedEvents.add(ENDIF(183, 189, 184, 115));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_If_Not_Defined_True_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =       
"#if ! defined A \n" +
"  #if !defined (A)\n" +
"  int alive;\n" +
"  /*alive comment*/\n" +
"  #elif 0\n" +
"    /*dead comment 1*/\n" +             
"  #else\n" +
"    /*dead comment 2*/\n" +              
"  #endif\n" +
"#endif\n" +
"\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);     
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(180, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(16, "A", 0, false, -1, new SourceRange(8, 18)));
    ExpectedEvents.add(IF(2, 18, 3, new SourceRange(5 ,19), CVK_True));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(35, "A", 0, false, -1, new SourceRange(26, 37)));
    ExpectedEvents.add(IF(21, 37, 22, new SourceRange(24 ,38), CVK_True));
    ExpectedEvents.add(ELIF(73, 80, 74, new SourceRange(78 ,81), CVK_NotEvaluated, 22));
    ExpectedEvents.add(ELSE(106, 111, 107, 22));
    ExpectedEvents.add(ENDIF(137, 143, 138, 22));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(74 ,138)));
    ExpectedEvents.add(ENDIF(144, 150, 145, 3));
    ExpectedEvents.add(FILE_GUARDED("Check_If_Not_Defined_True_Branch", "A", 3, "", 0));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_If_Not_Defined_False_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =         
"#define A\n" +             
"#if ! defined A\n" +
"int dead;\n" +
"/*dead comment*/\n" +
"#elif 1\n" +
"/*alive comment 1*/\n" +                    
"#endif\n" +
"\n" +            
"#if !defined (A)\n" +
"int dead;\n" +
"/*dead comment*/\n" +
"#elif 0\n" +
"/*dead comment 3*/\n" +             
"#else\n" +
"/*alive comment 2*/\n" +              
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(223, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(26, "A", 2, false, 0, new SourceRange(18, 27)));
    ExpectedEvents.add(IF(12, 27, 13, new SourceRange(15 ,28), CVK_False));
    ExpectedEvents.add(ELIF(55, 62, 56, new SourceRange(60 ,63), CVK_True, 13));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(92 ,163)));
    ExpectedEvents.add(ENDIF(83, 89, 84, 13));
    ExpectedEvents.add(PP_IS_DEFINED_EXPRESSION(105, "A", 2, false, 0, new SourceRange(96, 107)));
    ExpectedEvents.add(IF(91, 107, 92, new SourceRange(94 ,108), CVK_False));
    ExpectedEvents.add(ELIF(135, 142, 136, new SourceRange(140 ,143), CVK_False, 92));
    ExpectedEvents.add(ELSE(162, 167, 163, 92));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(92 ,163)));
    ExpectedEvents.add(ENDIF(188, 194, 189, 92));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void Check_IfDef_True_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#define A\n" + 
"#ifdef A\n" +
"int alive;\n" +
"/*alive comment*/\n" +            
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(85, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(IFDEF(12, 20,13, 19, CVK_True));
    ExpectedEvents.add(ENDIF(50, 56, 51, 13));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_IfDef_False_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#define A\n" + 
"#/*comment 1*//*comment 2*/ifdef/*comment 3*/B/*comment 4*/\n" +
"  /*dead comment*/\n" +            
"/*comment 21*/#/*comment 22*/endif/*comment 23*/\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(168, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(IFDEF(12, 71,39, 57, CVK_False));
    ExpectedEvents.add(ENDIF(105, 139, 120, 39));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(39 ,120)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_IfNDef_True_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#ifndef A\n" +
"int alive;\n" +
"/*alive comment*/\n" +
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);     
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(76, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(IFNDEF(2, 11,3, 10, CVK_True));
    ExpectedEvents.add(ENDIF(41, 47, 42, 3));
    ExpectedEvents.add(FILE_GUARDED("Check_IfNDef_True_Branch", "A", 10, "", 0));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }

  @Test
  public void Check_IfNDef_False_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#define A\n" +             
"#ifndef A\n" +
"int dead;\n" +
"/*dead comment*/\n" +
"#endif\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(84, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(IFNDEF(12, 21,13, 20, CVK_False));
    ExpectedEvents.add(ENDIF(49, 55, 50, 13));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(13 ,50)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens);
  }
  
  @Test
  public void CheckGuards() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    
    String Header = 
"/*comment before guard */" +            
"#ifndef CheckGuards\n" +
"#define CheckGuards\n" +
"int alive;\n" +
"/*alive comment*/\n" +
"// expected-warning@+1 {{extra tokens at end of #endif directive}}\n" +
"#endif CheckGuards\n" +
"/*comment after guard */";            
    String Source = 
"/*#include \"a.h\"*/\n" +
"#include \"header.h\"\n" +
"\n" +
"/*comment*/\n" +
"#include \"header.h\"\n" +
"\n";
    
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);     
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(76, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(21, 40, 22, "header.h", false, new CharSourceRange(30, 40, false), "/header.h", "/", "header.h", null));
    ExpectedEvents.add(FILE_CHANGED(77, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(IFNDEF(102, 121,103, 110, CVK_True));
    ExpectedEvents.add(MACRO_DEFINED(122, 141, 130, "CheckGuards", 122, false, 0));
    ExpectedEvents.add(ENDIF(238, 256, 239, 103));
    ExpectedEvents.add(FILE_GUARDED("/header.h", "CheckGuards", 110, "CheckGuards", 130));
    ExpectedEvents.add(FILE_CHANGED(41, ExitFile, C_User, 3));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(54, 73, 55, "header.h", false, new CharSourceRange(63, 73, false), "/header.h", "/", "header.h", null));
    ExpectedEvents.add(FILE_SKIPPED("/header.h", 63, C_User));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, null, "/header.h", Header, false);    
  }

  @Test
  public void Check_FILE_CHANGED_DoNotKeepComments() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
                
    String Source = 
"/*leading comment*/\n" +
"#include \"header.h\"\n" +
"/*next comment*/\n" +
"// expected-no-diagnostics\n";
    
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(87, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(22, 41, 23, "header.h", false, new CharSourceRange(31, 41, false), "/header.h", "/", "header.h", null));
    ExpectedEvents.add(FILE_CHANGED(88, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(42, ExitFile, C_User, 3));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, new PreprocessorInitializer(false), "/header.h", "", false);    
  }

  @Test
  public void Check_FILE_CHANGED_KeepComments() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
                
    String Source = 
"/*leading comment*/\n" +
"#include \"header.h\"\n" +
"/*next comment*/\n" +
"// expected-no-diagnostics\n";
    
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ExpectedTokens.push_back(tok.TokenKind.comment);     
    ExpectedTokens.push_back(tok.TokenKind.comment);     
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(87, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(22, 41, 23, "header.h", false, new CharSourceRange(31, 41, false), "/header.h", "/", "header.h", null));
    ExpectedEvents.add(FILE_CHANGED(88, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(42, ExitFile, C_User, 3));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, new PreprocessorInitializer(true), "/header.h", "/*header comment*/", false);    
  }
  
  @Test
  public void CheckIncompleteIfdef() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String  Source =
"// expected-error@+1 {{macro name must be an identifier}}\n" +
"#ifdef !\n" + 
"#endif\n"; 
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(77, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(IFDEF(60, 68,61, 67, CVK_False));
    ExpectedEvents.add(ENDIF(69, 75, 70, 61));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(61 ,70)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, null);
  }
  
  @Test
  public void CheckIfdefWithLeadingComment() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String  Source =
"/*comment*/#ifdef A\n" + 
"int dead;\n" + 
"/*end comment*/#endif A // expected-warning {{extra tokens at end of #endif directive}}\n"; 
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(121, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(IFDEF(13, 21,14, 20, CVK_False));
    ExpectedEvents.add(ENDIF(47, 119, 48, 14));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(14 ,48)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, null);
  }
  
  @Test 
  public void Check_Broken_Includes() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String  Source =
"/*comment*/#include \n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include\"\n" +
"// expected-error@-1 {{empty filename}}\n" +
"// expected-warning@-2 {{missing terminating '\"' character}}\n" +
"#include \"\n" +
"// expected-error@-1 {{empty filename}}\n" +
"// expected-warning@-2 {{missing terminating '\"' character}}\n" +
"#include<\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include <\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include >\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include'\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"// expected-warning@-2 {{missing terminating ' character}}\n" +
"#include\n" +
"// expected-error@-1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"// expected-error@+1 {{expected \"FILENAME\" or <FILENAME>}}\n" +
"#include";
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(846, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(373, 382, 374, "<", true, new CharSourceRange(381, 0, false), null, "", "", null));
    ExpectedEvents.add(INCLUSION_DIRECTIVE(442, 452, 443, "<", true, new CharSourceRange(451, 0, false), null, "", "", null));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, null);    
  }

  @Test
  public void Check_IfDef_Elif_Broken_Branch() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#define A\n" + 
"// expected-error@+4 {{expected value in expression}}\n" +
"// expected-error@+1 {{unterminated conditional directive}}\n" +
"#/*comment 1*//*comment 2*/ifdef/*comment 3*/B/*comment 4*/\n" +
"double dead;  /*dead comment*/\n" +            
"/*comment 21*/#/*comment 22*/elif/*comment 23*/\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();    
    ExpectedTokens.push_back(tok.TokenKind.comment);     
    ExpectedTokens.push_back(tok.TokenKind.comment);     
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(266, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(IFDEF(126, 185,153, 171, CVK_False));
    ExpectedEvents.add(ELIF(231, 264, 246, new SourceRange(250 ,265), CVK_False, 153));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(153 ,265)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, true);
  }
  
  @Test
  public void Check_IfDef_Else_Broken_Branch() {
    if (markAsSkippedIfNeed(TestState.Failed)) { return; }
    // NOTE: in PTH mode 
    // Error:unterminated conditional directive
    // is reported only for the outermost pp-block, because it jumps directly to the EOF
    // while plain Lexer report error for both unclosed blocks
    String Source = 
"#define A\n" + 
"#/*comment 1*//*comment 2*/ifdef/*comment 3*/A/*comment 4*/\n" +
"int alive;  /*alive comment*/\n" +            
"// expected-error@-2 {{unterminated conditional directive}}\n" +
"// expected-error@+2 {{unterminated conditional directive}}\n" +
"/*comment 21*/#/*comment 22*/else/*comment 23*/\n" + 
"/*comment 31*/#/*comment 32*/if/*comment 33*/ 1\n" + 
"double dead;\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();  
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);       
//    RunPreprocessorWithAndWithoutPTH(GATHER_EVENTS_FROM_NON_PTH_RUN, Source, ExpectedTokens, false);
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(332, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(2, 11, 10, "A", 2, false, 0));
    ExpectedEvents.add(IFDEF(12, 71,39, 57, CVK_True));
    ExpectedEvents.add(ELSE(236, 269, 251, 39));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(251 ,331)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, true);
    
  }
  
  @Test
  public void Check_Broken_Condition_Branches() {
    if (markAsSkippedIfNeed(TestState.Failed)) { return; }
    String Source =
"// expected-error@+28 {{#else after #else}}\n" +
"// expected-error@+25 {{#else after #else}}\n" +
"\n" +
"#else\n" +
"// expected-error@-1 {{#else without #if}}\n" +
"#elif\n" +
"// expected-error@-1 {{expected value in expression}}\n" +
"// expected-error@-2 {{#elif without #if}}\n" +
"#endif // bad code\n" +
"// expected-error@-1 {{#endif without #if}}\n" +
"\n" +
"#if A\n" +
"/*\n" +
"   #ifndef A\n" +
"\n" +
"   #else if B\n" +
"\n" +
"   #else\n" +
"\n" +
"   #endif\n" +
"*/\n" +
"\n" +
"   #if A\n" +
"\n" +
"   #else if !defined(B)    // comment\n" +
"\n" +
"   #else if C\n" +
"\n" +
  "   #else\n" +
"\n" +
"   #endif\n" +
"\n" +
"\n" +
"   #define AA '  \"  \n" +
"#endif A /*A*/\n" +
"// expected-warning@-1 {{extra tokens at end of #endif directive}}\n" +
"\n" +
"// expected-error@+3 {{token is not a valid binary operator in a preprocessor subexpression}}\n" +
"// expected-error@+2 {{unterminated conditional directive}}\n" +
"// expected-warning@+1 {{missing terminating ' character}}\n" +
"#if A '";
    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(780, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(IF(307, 312, 308, new SourceRange(310 ,313), CVK_False));
    ExpectedEvents.add(ENDIF(476, 490, 477, 308));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(773 ,779)));
    ExpectedEvents.add(IF(772, 779, 773, new SourceRange(775 ,779), CVK_False));
    ExpectedEvents.add(SOURCE_RANGE_SKIPPED(new SourceRange(773 ,779)));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, null, true);
//    RunPreprocessorWithAndWithoutPTH(GATHER_EVENTS_FROM_NON_PTH_RUN, Source, null, false);
  }

  @Test 
  public void Check_Incomplete_Pragma() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"#pragma\n" +
"#pragma GCC\n" +
"#pragma GCC poison\n" +
"// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();     
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(69, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, true);
    
  }
  
  @Test
  public void Check_Poinsoned_Identifiers() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source = 
"// When pasting creates poisoned identifiers, we error.\n" +
"#pragma GCC poison BLARG\n" +
"BLARG  // expected-error {{attempt to use a poisoned identifier}}\n" +
"#define XX BL ## ARG\n" +
"XX     // expected-error {{attempt to use a poisoned identifier}}\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();  
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.comment);       
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.comment);    
    ArrayList<PPCallbackEvent> ExpectedEvents = new ArrayList<PPCallbackEvent>();
    ExpectedEvents.add(FILE_CHANGED(2, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(237, EnterFile, C_User, FileID.getInvalidID()));
    ExpectedEvents.add(FILE_CHANGED(2, ExitFile, C_User, 2));
    ExpectedEvents.add(MACRO_DEFINED(149, 169, 157, "XX", 149, false, 0));
    ExpectedEvents.add(MACRO_EXPANDS(170, "XX", 149, false, 0, new SourceRange(170, 170), -1));
    RunPreprocessorWithAndWithoutPTH(ExpectedEvents, Source, ExpectedTokens, true);
  }  
  
  @Test
  public void Check_MSExt_MacroExpansion() {
    if (markAsSkippedIfNeed(TestState.Failed)) { return; }
    // from ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_msextensions.c
    final boolean CHECK_MORE = false;
String Source = 
"int foo;\n" +
"\n" +
"#define comment /##/  dead tokens live here\n" +
"comment This is stupidity\n" +
"\n" +
"int bar;\n" +
"\n" +
"#define nested(x) int x comment cute little dead tokens...\n" +
"\n" +
"nested(baz)  rise of the dead tokens\n" +
"\n" +
";\n" +
"\n";
if (CHECK_MORE) {
Source +=
"// rdar://8197149 - VC++ allows invalid token pastes: (##baz\n" +
"#define foo(x) abc(x)\n" +
"#define bar(y) foo(##baz(y))\n" +
"bar(q)\n" +
"\n" +
"// CHECK: abc(baz(q))\n";
}
Source+="// expected-no-diagnostics\n";
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();  
    // int foo;
    ExpectedTokens.push_back(tok.TokenKind.kw_int);    
    ExpectedTokens.push_back(tok.TokenKind.identifier);    
    ExpectedTokens.push_back(tok.TokenKind.semi);    

    // int bar;
    ExpectedTokens.push_back(tok.TokenKind.kw_int);    
    ExpectedTokens.push_back(tok.TokenKind.identifier);    
    ExpectedTokens.push_back(tok.TokenKind.semi);    
    
    //int baz
    //
    //;
    ExpectedTokens.push_back(tok.TokenKind.kw_int);    
    ExpectedTokens.push_back(tok.TokenKind.identifier);    
    ExpectedTokens.push_back(tok.TokenKind.semi);
    if (CHECK_MORE) {
      //abc(baz(q))
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.l_paren);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.l_paren);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.r_paren);
      ExpectedTokens.push_back(tok.TokenKind.r_paren);
    }
    boolean oldVal = super.LangOpts.MicrosoftExt;
    try {
      super.LangOpts.MicrosoftExt = true;
      PreprocessorInitializer preprocessorInitializer = new PreprocessorInitializer(false) {
        @Override
        protected PreprocessorOptions getPreprocessorOptions() {
          PreprocessorOptions out = super.getPreprocessorOptions();
          return out;
        }

        @Override
        protected void checkTokens(std.vector<Token> toks) {
          std.string sourceTextFoo = getSourceText(toks.$at(0), toks.$at(2));
          std.string sourceTextBar = getSourceText(toks.$at(3), toks.$at(5));
          ASSERT_EQ("int foo;", sourceTextFoo);
          ASSERT_EQ("int bar;", sourceTextBar);
          IdentifierInfo identBaz = toks.$at(7).getIdentifierInfo();
          EXPECT_EQ("baz", Native.$toString(identBaz.getNameStart(), identBaz.getLength()));
          if (CHECK_MORE) {
            std.string sourceTextABC = getSourceText(toks.$at(9), toks.$at(14));
            IdentifierInfo identABC = toks.$at(9).getIdentifierInfo();
            EXPECT_EQ("abc", Native.$toString(identABC.getNameStart(), identABC.getLength()));
            IdentifierInfo identBAZ = toks.$at(11).getIdentifierInfo();
            EXPECT_EQ("baz", Native.$toString(identBAZ.getNameStart(), identBAZ.getLength()));
            IdentifierInfo identQ = toks.$at(13).getIdentifierInfo();
            EXPECT_EQ("q", Native.$toString(identQ.getNameStart(), identQ.getLength()));
          }
        }
      };
      RunPreprocessorWithAndWithoutPTH(GATHER_EVENTS_FROM_NON_PTH_RUN, Source, ExpectedTokens, preprocessorInitializer, "", "", false);
    } finally {
      super.LangOpts.MicrosoftExt = oldVal;
    }
    
  }
}
