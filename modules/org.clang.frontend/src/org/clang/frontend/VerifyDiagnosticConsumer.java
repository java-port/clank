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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.llvm.DenseMapInfoFileID;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import static org.clang.frontend.impl.VerifyDiagnosticConsumerStatics.*;


/// VerifyDiagnosticConsumer - Create a diagnostic client which will use
/// markers in the input source to check that all the emitted diagnostics match
/// those expected.
///
/// USING THE DIAGNOSTIC CHECKER:
///
/// Indicating that a line expects an error or a warning is simple. Put a
/// comment on the line that has the diagnostic, use:
///
/// \code
///   expected-{error,warning,remark,note}
/// \endcode
///
/// to tag if it's an expected error, remark or warning, and place the expected
/// text between {{ and }} markers. The full text doesn't have to be included,
/// only enough to ensure that the correct diagnostic was emitted.
///
/// Here's an example:
///
/// \code
///   int A = B; // expected-error {{use of undeclared identifier 'B'}}
/// \endcode
///
/// You can place as many diagnostics on one line as you wish. To make the code
/// more readable, you can use slash-newline to separate out the diagnostics.
///
/// Alternatively, it is possible to specify the line on which the diagnostic
/// should appear by appending "@<line>" to "expected-<type>", for example:
///
/// \code
///   #warning some text
///   // expected-warning@10 {{some text}}
/// \endcode
///
/// The line number may be absolute (as above), or relative to the current
/// line by prefixing the number with either '+' or '-'.
///
/// If the diagnostic is generated in a separate file, for example in a shared
/// header file, it may be beneficial to be able to declare the file in which
/// the diagnostic will appear, rather than placing the expected-* directive in
/// the actual file itself.  This can be done using the following syntax:
///
/// \code
///   // expected-error@path/include.h:15 {{error message}}
/// \endcode
///
/// The path can be absolute or relative and the same search paths will be used
/// as for #include directives.  The line number in an external file may be
/// substituted with '*' meaning that any line number will match (useful where
/// the included file is, for example, a system header where the actual line
/// number may change and is not critical).
///
/// The simple syntax above allows each specification to match exactly one
/// error.  You can use the extended syntax to customize this. The extended
/// syntax is "expected-<type> <n> {{diag text}}", where \<type> is one of
/// "error", "warning" or "note", and \<n> is a positive integer. This allows
/// the diagnostic to appear as many times as specified. Example:
///
/// \code
///   void f(); // expected-note 2 {{previous declaration is here}}
/// \endcode
///
/// Where the diagnostic is expected to occur a minimum number of times, this
/// can be specified by appending a '+' to the number. Example:
///
/// \code
///   void f(); // expected-note 0+ {{previous declaration is here}}
///   void g(); // expected-note 1+ {{previous declaration is here}}
/// \endcode
///
/// In the first example, the diagnostic becomes optional, i.e. it will be
/// swallowed if it occurs, but will not generate an error if it does not
/// occur.  In the second example, the diagnostic must occur at least once.
/// As a short-hand, "one or more" can be specified simply by '+'. Example:
///
/// \code
///   void g(); // expected-note + {{previous declaration is here}}
/// \endcode
///
/// A range can also be specified by "<n>-<m>".  Example:
///
/// \code
///   void f(); // expected-note 0-1 {{previous declaration is here}}
/// \endcode
///
/// In this example, the diagnostic may appear only once, if at all.
///
/// Regex matching mode may be selected by appending '-re' to type and
/// including regexes wrapped in double curly braces in the directive, such as:
///
/// \code
///   expected-error-re {{format specifies type 'wchar_t **' (aka '{{.+}}')}}
/// \endcode
///
/// Examples matching error: "variable has incomplete type 'struct s'"
///
/// \code
///   // expected-error {{variable has incomplete type 'struct s'}}
///   // expected-error {{variable has incomplete type}}
///
///   // expected-error-re {{variable has type 'struct {{.}}'}}
///   // expected-error-re {{variable has type 'struct {{.*}}'}}
///   // expected-error-re {{variable has type 'struct {{(.*)}}'}}
///   // expected-error-re {{variable has type 'struct{{[[:space:]](.*)}}'}}
/// \endcode
///
/// VerifyDiagnosticConsumer expects at least one expected-* directive to
/// be found inside the source code.  If no diagnostics are expected the
/// following directive can be used to indicate this:
///
/// \code
///   // expected-no-diagnostics
/// \endcode
///
//<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 141,
 FQN="clang::VerifyDiagnosticConsumer", NM="_ZN5clang24VerifyDiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumerE")
//</editor-fold>
public class VerifyDiagnosticConsumer extends /*public*/ DiagnosticConsumer implements /*public*/ CommentHandler, Destructors.ClassWithDestructor {
/*public:*/
  /// Directive - Abstract class representing a parsed verify directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 146,
   FQN="clang::VerifyDiagnosticConsumer::Directive", NM="_ZN5clang24VerifyDiagnosticConsumer9DirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9DirectiveE")
  //</editor-fold>
  public abstract static class Directive implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::create">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 887,
     FQN="clang::VerifyDiagnosticConsumer::Directive::create", NM="_ZN5clang24VerifyDiagnosticConsumer9Directive6createEbNS_14SourceLocationES2_bN4llvm9StringRefEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9Directive6createEbNS_14SourceLocationES2_bN4llvm9StringRefEjj")
    //</editor-fold>
    public static std.unique_ptr<VerifyDiagnosticConsumer.Directive> create(boolean RegexKind, 
          SourceLocation DirectiveLoc, 
          SourceLocation DiagnosticLoc, 
          boolean MatchAnyLine, StringRef Text, 
          /*uint*/int Min, /*uint*/int Max) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!RegexKind) {
          return $c$.clean(new std.unique_ptr<VerifyDiagnosticConsumer.Directive>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new StandardDirective(DirectiveLoc, DiagnosticLoc, 
                  MatchAnyLine, Text, Min, Max)))));
        }
        
        // Parse the directive into a regular expression.
        std.string RegexStr/*J*/= new std.string();
        StringRef S = new StringRef(Text);
        while (!S.empty()) {
          if (S.startswith(/*STRINGREF_STR*/"{{")) {
            S.$assignMove(S.drop_front(2));
            /*size_t*/int RegexMatchLength = S.find(/*STRINGREF_STR*/"}}");
            assert (RegexMatchLength != StringRef.npos);
            // Append the regex, enclosed in parentheses.
            RegexStr.$addassign_T$C$P(/*KEEP_STR*/"(");
            RegexStr.append(S.data(), RegexMatchLength);
            RegexStr.$addassign_T$C$P(/*KEEP_STR*/")");
            S.$assignMove(S.drop_front(RegexMatchLength + 2));
          } else {
            /*size_t*/int VerbatimMatchLength = S.find(/*STRINGREF_STR*/"{{");
            if (VerbatimMatchLength == StringRef.npos) {
              VerbatimMatchLength = S.size();
            }
            // Escape and append the fixed string.
            RegexStr.$addassign(Regex.escape(S.substr(0, VerbatimMatchLength)));
            S.$assignMove(S.drop_front(VerbatimMatchLength));
          }
        }
        
        return $c$.clean(new std.unique_ptr<VerifyDiagnosticConsumer.Directive>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RegexDirective(DirectiveLoc, DiagnosticLoc, MatchAnyLine, Text, Min, Max, RegexStr)))));
      } finally {
        $c$.$destroy();
      }
    }

  /*public:*/
    /// Constant representing n or more matches.
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed to INT_MAX*/)
    public static final/*const*//*uint*/int MaxCount = INT_MAX;
    
    public SourceLocation DirectiveLoc;
    public SourceLocation DiagnosticLoc;
    public /*const*/std.string Text;
    public /*uint*/int Min;
    public /*uint*/int Max;
    public boolean MatchAnyLine;
    
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::~Directive">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 164,
     FQN="clang::VerifyDiagnosticConsumer::Directive::~Directive", NM="_ZN5clang24VerifyDiagnosticConsumer9DirectiveD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9DirectiveD0Ev")
    //</editor-fold>
    public /*virtual*/ void $destroy() {
      //START JDestroy
      Text.$destroy();
      //END JDestroy
    }

    
    // Returns true if directive text is valid.
    // Otherwise returns false and populates E.
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 168,
     FQN="clang::VerifyDiagnosticConsumer::Directive::isValid", NM="_ZN5clang24VerifyDiagnosticConsumer9Directive7isValidERSs",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9Directive7isValidERSs")
    //</editor-fold>
    public abstract /*virtual*/ boolean isValid(std.string/*&*/ Error)/* = 0*/;

    
    // Returns true on match.
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::match">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 171,
     FQN="clang::VerifyDiagnosticConsumer::Directive::match", NM="_ZN5clang24VerifyDiagnosticConsumer9Directive5matchEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9Directive5matchEN4llvm9StringRefE")
    //</editor-fold>
    public abstract /*virtual*/ boolean match(StringRef S)/* = 0*/;

  /*protected:*/
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::Directive">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 174,
     FQN="clang::VerifyDiagnosticConsumer::Directive::Directive", NM="_ZN5clang24VerifyDiagnosticConsumer9DirectiveC1ENS_14SourceLocationES2_bN4llvm9StringRefEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9DirectiveC1ENS_14SourceLocationES2_bN4llvm9StringRefEjj")
    //</editor-fold>
    protected Directive(SourceLocation DirectiveLoc, SourceLocation DiagnosticLoc, 
        boolean MatchAnyLine, StringRef Text, /*uint*/int Min, /*uint*/int Max) {
      // : DirectiveLoc(DirectiveLoc), DiagnosticLoc(DiagnosticLoc), Text(Text.operator basic_string()), Min(Min), Max(Max), MatchAnyLine(MatchAnyLine) 
      //START JInit
      this.DirectiveLoc = new SourceLocation(DirectiveLoc);
      this.DiagnosticLoc = new SourceLocation(DiagnosticLoc);
      this.Text = Text.$string();
      this.Min = Min;
      this.Max = Max;
      this.MatchAnyLine = MatchAnyLine;
      //END JInit
      assert (!DirectiveLoc.isInvalid()) : "DirectiveLoc is invalid!";
      assert (!DiagnosticLoc.isInvalid()) : "DiagnosticLoc is invalid!";
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::Directive">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 183,
     FQN="clang::VerifyDiagnosticConsumer::Directive::Directive", NM="_ZN5clang24VerifyDiagnosticConsumer9DirectiveC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9DirectiveC1ERKS1_")
    //</editor-fold>
    private Directive(/*const*/ Directive /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::Directive::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 184,
     FQN="clang::VerifyDiagnosticConsumer::Directive::operator=", NM="_ZN5clang24VerifyDiagnosticConsumer9DirectiveaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer9DirectiveaSERKS1_")
    //</editor-fold>
    private void $assign(/*const*/ Directive /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    
    @Override public String toString() {
      return "" + "DirectiveLoc=" + DirectiveLoc // NOI18N
                + ", DiagnosticLoc=" + DiagnosticLoc // NOI18N
                + ", Text=" + Text // NOI18N
                + ", Min=" + Min // NOI18N
                + ", Max=" + Max // NOI18N
                + ", MatchAnyLine=" + MatchAnyLine; // NOI18N
    }
  };
  
  /*typedef std::vector<std::unique_ptr<Directive> > DirectiveList*/
//  public final class DirectiveList extends std.vector<std.unique_ptr<Directive>>{ };
  
  /// ExpectedData - owns directive objects and deletes on destructor.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::ExpectedData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 191,
   FQN="clang::VerifyDiagnosticConsumer::ExpectedData", NM="_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataE")
  //</editor-fold>
  public static class/*struct*/ ExpectedData implements Destructors.ClassWithDestructor {
    public std.vector<std.unique_ptr<Directive>> Errors;
    public std.vector<std.unique_ptr<Directive>> Warnings;
    public std.vector<std.unique_ptr<Directive>> Remarks;
    public std.vector<std.unique_ptr<Directive>> Notes;
    
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::ExpectedData::Reset">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 197,
     FQN="clang::VerifyDiagnosticConsumer::ExpectedData::Reset", NM="_ZN5clang24VerifyDiagnosticConsumer12ExpectedData5ResetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer12ExpectedData5ResetEv")
    //</editor-fold>
    public void Reset() {
      Errors.clear();
      Warnings.clear();
      Remarks.clear();
      Notes.clear();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::ExpectedData::~ExpectedData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 191,
     FQN="clang::VerifyDiagnosticConsumer::ExpectedData::~ExpectedData", NM="_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Notes.$destroy();
      Remarks.$destroy();
      Warnings.$destroy();
      Errors.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::ExpectedData::ExpectedData">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF*/,
     optimized = Converted.Optimization.VALUE_TYPE/*const default value*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 191,
     FQN="clang::VerifyDiagnosticConsumer::ExpectedData::ExpectedData", NM="_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer12ExpectedDataC1Ev")
    //</editor-fold>
    public /*inline*/ ExpectedData() {
      // : Errors(), Warnings(), Remarks(), Notes() 
      //START JInit
      this.Errors = new std.vector<std.unique_ptr<Directive>>(std.unique_ptr.<Directive>$Default());
      this.Warnings = new std.vector<std.unique_ptr<Directive>>(std.unique_ptr.<Directive>$Default());
      this.Remarks = new std.vector<std.unique_ptr<Directive>>(std.unique_ptr.<Directive>$Default());
      this.Notes = new std.vector<std.unique_ptr<Directive>>(std.unique_ptr.<Directive>$Default());
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Errors=" + Errors // NOI18N
                + ", Warnings=" + Warnings // NOI18N
                + ", Remarks=" + Remarks // NOI18N
                + ", Notes=" + Notes; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::DirectiveStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 205,
   FQN="clang::VerifyDiagnosticConsumer::DirectiveStatus", NM="_ZN5clang24VerifyDiagnosticConsumer15DirectiveStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer15DirectiveStatusE")
  //</editor-fold>
  public enum DirectiveStatus implements Native.ComparableLower {
    HasNoDirectives(0),
    HasNoDirectivesReported(HasNoDirectives.getValue() + 1),
    HasExpectedNoDiagnostics(HasNoDirectivesReported.getValue() + 1),
    HasOtherExpectedDirectives(HasExpectedNoDiagnostics.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DirectiveStatus valueOf(int val) {
      DirectiveStatus out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DirectiveStatus[] VALUES;
      private static final DirectiveStatus[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DirectiveStatus kind : DirectiveStatus.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DirectiveStatus[min < 0 ? (1-min) : 0];
        VALUES = new DirectiveStatus[max >= 0 ? (1+max) : 0];
        for (DirectiveStatus kind : DirectiveStatus.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DirectiveStatus(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DirectiveStatus)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DirectiveStatus)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private DiagnosticsEngine /*&*/ Diags;
  private DiagnosticConsumer /*P*/ PrimaryClient;
  private std.unique_ptr<DiagnosticConsumer> PrimaryClientOwner;
  private std.unique_ptr<TextDiagnosticBuffer> Buffer;
  private /*const*/ Preprocessor /*P*/ CurrentPreprocessor;
  private /*const*/ LangOptions /*P*/ LangOpts;
  private SourceManager /*P*/ SrcManager;
  private /*uint*/int ActiveSourceFiles;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed to ref*/)
  private type$ref<DirectiveStatus> Status;
  private ExpectedData ED;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::CheckDiagnostics">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 807,
   FQN="clang::VerifyDiagnosticConsumer::CheckDiagnostics", NM="_ZN5clang24VerifyDiagnosticConsumer16CheckDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer16CheckDiagnosticsEv")
  //</editor-fold>
  private void CheckDiagnostics() {
    std.unique_ptr<DiagnosticConsumer> Owner = null;
    try {
      // Ensure any diagnostics go to the primary client.
      DiagnosticConsumer /*P*/ CurClient = Diags.getClient();
      Owner = Diags.takeClient();
      Diags.setClient(PrimaryClient, false);
      // In a debug build, scan through any files that may have been missed
      // during parsing and issue a fatal error if directives are contained
      // within these files.  If a fatal error occurs, this suggests that
      // this file is being parsed separately from the main file, in which
      // case consider moving the directives to the correct place, if this
      // is applicable.
      if ($greater_uint(UnparsedFiles.size(), 0)) {
        // Generate a cache of parsed FileEntry pointers for alias lookups.
        SmallPtrSet</*const*/ FileEntry /*P*/> ParsedFileCache/*J*/= new SmallPtrSet</*const*/ FileEntry /*P*/>(FileEntry.DMI$FileEntryPtr, 8);
        for (DenseMapIterator<FileID, /*const*/ FileEntry /*P*/> I = ParsedFiles.begin(), 
            End = ParsedFiles.end(); I.$noteq(/*NO_ITER_COPY*/End); I.$preInc()) {
          {
            /*const*/ FileEntry /*P*/ FE = I.$arrow().second;
            if ((FE != null)) {
              ParsedFileCache.insert(FE);
            }
          }
        }
        
        // Iterate through list of unparsed files.
        for (DenseMapIterator<FileID, UnparsedFileStatus> I = UnparsedFiles.begin(), 
            End = UnparsedFiles.end(); I.$noteq(/*NO_ITER_COPY*/End); I.$preInc()) {
          /*const*/ UnparsedFileStatus /*&*/ Status = I.$arrow().second;
          /*const*/ FileEntry /*P*/ FE = Status.getFile();
          
          // Skip files that have been parsed via an alias.
          if ((FE != null) && (ParsedFileCache.count(FE) != 0)) {
            continue;
          }
          
          // Report a fatal error if this file contained directives.
          if (Status.foundDirectives()) {
            llvm.report_fatal_error(new Twine(/*KEEP_STR*/"-verify directives found after rather than during normal parsing of ", 
                    /*STRINGREF_STR*/(FE != null) ? FE.getName() : $("(unknown)")));
          }
        }
        
        // UnparsedFiles has been processed now, so clear it.
        UnparsedFiles.clear();
      }
      // !NDEBUG
      if ((SrcManager != null)) {
        // Produce an error if no expected-* directives could be found in the
        // source file(s) processed.
        if (Status.$deref() == DirectiveStatus.HasNoDirectives) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(diag.err_verify_no_directives)).setForceEmit());
            ++NumErrors;
            Status.$set(DirectiveStatus.HasNoDirectivesReported);
          } finally {
            $c$.$destroy();
          }
        }
        
        // Check that the expected diagnostics occurred.
        NumErrors += CheckResults(Diags, /*Deref*/SrcManager, Buffer.$star(), ED);
      } else {
        /*const DiagnosticLevelMask*//*uint*/int DiagMask = $bitnot_DiagnosticLevelMask(Diags.getDiagnosticOptions().getVerifyIgnoreUnexpected());
        if (((boolean)($bitand_DiagnosticLevelMask(/*KEEP_ENUM*/DiagnosticLevelMask.Error, /*KEEP_ENUM*/DiagMask) != 0))) {
          NumErrors += PrintUnexpected(Diags, (SourceManager /*P*/ )null, Buffer.$arrow().err_begin(), 
              Buffer.$arrow().err_end(), $error);
        }
        if (((boolean)($bitand_DiagnosticLevelMask(/*KEEP_ENUM*/DiagnosticLevelMask.Warning, /*KEEP_ENUM*/DiagMask) != 0))) {
          NumErrors += PrintUnexpected(Diags, (SourceManager /*P*/ )null, Buffer.$arrow().warn_begin(), 
              Buffer.$arrow().warn_end(), $("warn"));
        }
        if (((boolean)($bitand_DiagnosticLevelMask(/*KEEP_ENUM*/DiagnosticLevelMask.Remark, /*KEEP_ENUM*/DiagMask) != 0))) {
          NumErrors += PrintUnexpected(Diags, (SourceManager /*P*/ )null, Buffer.$arrow().remark_begin(), 
              Buffer.$arrow().remark_end(), $("remark"));
        }
        if (((boolean)($bitand_DiagnosticLevelMask(/*KEEP_ENUM*/DiagnosticLevelMask.Note, /*KEEP_ENUM*/DiagMask) != 0))) {
          NumErrors += PrintUnexpected(Diags, (SourceManager /*P*/ )null, Buffer.$arrow().note_begin(), 
              Buffer.$arrow().note_end(), $("note"));
        }
      }
      
      Diags.setClient(CurClient, Owner.release() != (DiagnosticConsumer)null);
      
      // Reset the buffer, we have processed all the diagnostics in it.
      Buffer.reset(new TextDiagnosticBuffer());
      ED.Reset();
    } finally {
      if (Owner != null) { Owner.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::setSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 225,
   FQN="clang::VerifyDiagnosticConsumer::setSourceManager", NM="_ZN5clang24VerifyDiagnosticConsumer16setSourceManagerERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer16setSourceManagerERNS_13SourceManagerE")
  //</editor-fold>
  private void setSourceManager(SourceManager /*&*/ SM) {
    assert ((!(SrcManager != null) || SrcManager == /*AddrOf*/SM)) : "SourceManager changed!";
    SrcManager = /*AddrOf*/SM;
  }

  
  // These facilities are used for validation in debug builds.
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 231,
   FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus", NM="_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusE")
  //</editor-fold>
  private static class UnparsedFileStatus {
    private PointerBoolPair</*const*/ FileEntry/*P*/> Data;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 234,
     FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus", NM="_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1EPKNS_9FileEntryEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1EPKNS_9FileEntryEb")
    //</editor-fold>
    public UnparsedFileStatus(/*const*/ FileEntry /*P*/ File, boolean FoundDirectives) {
      // : Data(File, FoundDirectives) 
      //START JInit
      this.Data = new PointerBoolPair</*const*/ FileEntry/*P*/>(File, FoundDirectives);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::getFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 236,
     FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::getFile", NM="_ZNK5clang24VerifyDiagnosticConsumer18UnparsedFileStatus7getFileEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZNK5clang24VerifyDiagnosticConsumer18UnparsedFileStatus7getFileEv")
    //</editor-fold>
    public /*const*/ FileEntry /*P*/ getFile() /*const*/ {
      return Data.getPointer();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::foundDirectives">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 237,
     FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::foundDirectives", NM="_ZNK5clang24VerifyDiagnosticConsumer18UnparsedFileStatus15foundDirectivesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZNK5clang24VerifyDiagnosticConsumer18UnparsedFileStatus15foundDirectivesEv")
    //</editor-fold>
    public boolean foundDirectives() /*const*/ {
      return Data.getInt();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 231,
     FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus", NM="_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1ERKS1_")
    //</editor-fold>
    public /*inline*/ UnparsedFileStatus(/*const*/ UnparsedFileStatus /*&*/ $Prm0) {
      // : Data(.Data) 
      //START JInit
      this.Data = new PointerBoolPair</*const*/ FileEntry/*P*/>($Prm0.Data);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 231,
     FQN="clang::VerifyDiagnosticConsumer::UnparsedFileStatus::UnparsedFileStatus", NM="_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer18UnparsedFileStatusC1EOS1_")
    //</editor-fold>
    public /*inline*/ UnparsedFileStatus(JD$Move _dparam, UnparsedFileStatus /*&&*/$Prm0) {
      // : Data(static_cast<UnparsedFileStatus &&>().Data) 
      //START JInit
      this.Data = new PointerBoolPair</*const*/ FileEntry/*P*/>(JD$Move.INSTANCE, $Prm0.Data);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Data=" + Data; // NOI18N
    }
  };
  /*typedef llvm::DenseMap<FileID, const FileEntry *> ParsedFilesMap*/
//  public final class ParsedFilesMap extends DenseMap<FileID, /*const*/ FileEntry /*P*/ >{ };
  /*typedef llvm::DenseMap<FileID, UnparsedFileStatus> UnparsedFilesMap*/
//  public final class UnparsedFilesMap extends DenseMap<FileID, UnparsedFileStatus>{ };
  private DenseMap<FileID, /*const*/ FileEntry /*P*/ > ParsedFiles;
  private DenseMap<FileID, UnparsedFileStatus> UnparsedFiles;
/*public:*/
  /// Create a new verifying diagnostic client, which will issue errors to
  /// the currently-attached diagnostic client when a diagnostic does not match 
  /// what is expected (as indicated in the source file).
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::VerifyDiagnosticConsumer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF and Status as ref*/,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 30,
   FQN="clang::VerifyDiagnosticConsumer::VerifyDiagnosticConsumer", NM="_ZN5clang24VerifyDiagnosticConsumerC1ERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumerC1ERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public VerifyDiagnosticConsumer(DiagnosticsEngine /*&*/ Diags_) {
    // : DiagnosticConsumer(), CommentHandler(), Diags(Diags_), PrimaryClient(Diags.getClient()), PrimaryClientOwner(Diags.takeClient()), Buffer(new TextDiagnosticBuffer()), CurrentPreprocessor(null), LangOpts(null), SrcManager(null), ActiveSourceFiles(0), Status(HasNoDirectives), ED(), ParsedFiles(), UnparsedFiles() 
    //START JInit
    super();
    $CommentHandler();
    this./*&*/Diags=/*&*/Diags_;
    this.PrimaryClient = Diags.getClient();
    this.PrimaryClientOwner = Diags.takeClient();
    this.Buffer = new std.unique_ptr<TextDiagnosticBuffer>(new TextDiagnosticBuffer());
    this.CurrentPreprocessor = null;
    this.LangOpts = null;
    this.SrcManager = null;
    this.ActiveSourceFiles = 0;
    this.Status = create_type$ref(DirectiveStatus.HasNoDirectives);
    this.ED = new ExpectedData();
    this.ParsedFiles = new DenseMap<FileID, /*const*/ FileEntry /*P*/ >(DenseMapInfoFileID.$Info(), null);
    this.UnparsedFiles = new DenseMap<FileID, UnparsedFileStatus>(DenseMapInfoFileID.$Info(), null/*PERF: new UnparsedFileStatus()*/);
    //END JInit
    if (Diags.hasSourceManager()) {
      setSourceManager(Diags.getSourceManager());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::~VerifyDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 41,
   FQN="clang::VerifyDiagnosticConsumer::~VerifyDiagnosticConsumer", NM="_ZN5clang24VerifyDiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!(ActiveSourceFiles != 0)) : "Incomplete parsing of source files!";
      assert (!(CurrentPreprocessor != null)) : "CurrentPreprocessor should be invalid!";
      SrcManager = null;
      CheckDiagnostics();
      $c$.clean($c$.track(Diags.takeClient()).release());
    } finally {
      $c$.$destroy();
    }
    //START JDestroy
    UnparsedFiles.$destroy();
    ParsedFiles.$destroy();
    ED.$destroy();
    Buffer.$destroy();
    PrimaryClientOwner.$destroy();
    super.$destroy();
    //~CommentHandler;
    //END JDestroy
  }

  
  
  // DiagnosticConsumer interface.
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PreprocessorImplementation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 73,
   FQN="clang::VerifyDiagnosticConsumer::BeginSourceFile", NM="_ZN5clang24VerifyDiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LangOpts, 
                 /*const*/ PreprocessorImplementation /*P*/ PP)/* override*/ {
    // Attach comment handler on first invocation.
    if (++ActiveSourceFiles == 1) {
      if ((PP != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          CurrentPreprocessor = (Preprocessor)PP;
          this.LangOpts = /*AddrOf*/LangOpts;
          setSourceManager(PP.getSourceManager());
          ((/*const_cast*/Preprocessor /*P*/ )(PP)).addCommentHandler(this);
          // Debug build tracks parsed files.
          ((/*const_cast*/Preprocessor /*P*/ )(PP)).addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new VerifyFileTracker(/*Deref*/this, /*Deref*/SrcManager)))))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
    assert ((!(PP != null) || CurrentPreprocessor == PP)) : "Preprocessor changed!";
    PrimaryClient.BeginSourceFile(LangOpts, PP);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 94,
   FQN="clang::VerifyDiagnosticConsumer::EndSourceFile", NM="_ZN5clang24VerifyDiagnosticConsumer13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer13EndSourceFileEv")
  //</editor-fold>
  @Override public void EndSourceFile()/* override*/ {
    assert ((ActiveSourceFiles != 0)) : "No active source files!";
    PrimaryClient.EndSourceFile();
    
    // Detach comment handler once last active source file completed.
    if (--ActiveSourceFiles == 0) {
      if ((CurrentPreprocessor != null)) {
        ((/*const_cast*/Preprocessor /*P*/ )(CurrentPreprocessor)).removeCommentHandler(this);
      }
      
      // Check diagnostics once last file completed.
      CheckDiagnostics();
      CurrentPreprocessor = null;
      LangOpts = null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::ParsedStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/VerifyDiagnosticConsumer.h", line = 256,
   FQN="clang::VerifyDiagnosticConsumer::ParsedStatus", NM="_ZN5clang24VerifyDiagnosticConsumer12ParsedStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer12ParsedStatusE")
  //</editor-fold>
  public enum ParsedStatus implements Native.ComparableLower {
    /// File has been processed via HandleComment.
    IsParsed(0),
    
    /// File has diagnostics and may have directives.
    IsUnparsed(IsParsed.getValue() + 1),
    
    /// File has diagnostics but guaranteed no directives.
    IsUnparsedNoDirectives(IsUnparsed.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ParsedStatus valueOf(int val) {
      ParsedStatus out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ParsedStatus[] VALUES;
      private static final ParsedStatus[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ParsedStatus kind : ParsedStatus.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ParsedStatus[min < 0 ? (1-min) : 0];
        VALUES = new ParsedStatus[max >= 0 ? (1+max) : 0];
        for (ParsedStatus kind : ParsedStatus.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ParsedStatus(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ParsedStatus)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ParsedStatus)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Update lists of parsed and unparsed files.
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::UpdateParsedFileStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 774,
   FQN="clang::VerifyDiagnosticConsumer::UpdateParsedFileStatus", NM="_ZN5clang24VerifyDiagnosticConsumer22UpdateParsedFileStatusERNS_13SourceManagerENS_6FileIDENS0_12ParsedStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer22UpdateParsedFileStatusERNS_13SourceManagerENS_6FileIDENS0_12ParsedStatusE")
  //</editor-fold>
  public void UpdateParsedFileStatus(SourceManager /*&*/ SM, 
                        FileID FID, 
                        ParsedStatus PS) {
    // Check SourceManager hasn't changed.
    setSourceManager(SM);
    if (FID.isInvalid()) {
      return;
    }
    
    /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(/*NO_COPY*/FID);
    if (PS == ParsedStatus.IsParsed) {
      // Move the FileID from the unparsed set to the parsed set.
      UnparsedFiles.erase(FID);
      ParsedFiles.insert_pair$KeyT$ValueT(std.make_pair_T_Ptr(FID, FE));
    } else if (!(ParsedFiles.count(FID) != 0) && !(UnparsedFiles.count(FID) != 0)) {
      // Add the FileID to the unparsed set if we haven't seen it before.
      
      // Check for directives.
      boolean FoundDirectives;
      if (PS == ParsedStatus.IsUnparsedNoDirectives) {
        FoundDirectives = false;
      } else {
        FoundDirectives = !(LangOpts != null) || findDirectives(SM, new FileID(FID), /*Deref*/LangOpts);
      }
      
      // Add the FileID to the unparsed set.
      UnparsedFiles.insert_pair$KeyT$ValueT(std.make_pair(FID, 
              new UnparsedFileStatus(FE, FoundDirectives)));
    }
  }

  
  
  /// HandleComment - Hook into the preprocessor and extract comments containing
  ///  expected errors and warnings.
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::HandleComment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF*/,
   optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 520,
   FQN="clang::VerifyDiagnosticConsumer::HandleComment", NM="_ZN5clang24VerifyDiagnosticConsumer13HandleCommentERNS_12PreprocessorENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer13HandleCommentERNS_12PreprocessorENS_11SourceRangeE")
  //</editor-fold>
  @Override public boolean HandleComment(Preprocessor /*&*/ PP, 
               SourceRange Comment)/* override*/ {
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    // If this comment is for a different source manager, ignore it.
    if ((SrcManager != null) && /*AddrOf*/SM != SrcManager) {
      return false;
    }
    
    // JAVA PERF: SourceLocation CommentBegin = Comment.getBegin();

    // JAVA PERF:
     StringRef C/*J*/= SM.getCharacterDataStringRef_ValidOnly(Comment.$getBegin(), Comment.$getEnd());
//    /*const*/char$ptr/*char P*/ CommentRaw = $tryClone(SM.getCharacterData(/*NO_COPY*/CommentBegin));
//    StringRef C/*J*/= new StringRef(CommentRaw, SM.getCharacterData(Comment.getEnd()).$sub(CommentRaw));
    if (C.empty()) {
      return false;
    }
    // JAVA moved local var here
    /*SourceLocation*/int CommentBegin = Comment.$getBegin();
    // Fold any "\<EOL>" sequences
    /*size_t*/int loc = C.find($$BACK_SLASH);
    if (loc == StringRef.npos) {
      ParseDirective(new StringRef(C), /*AddrOf*/ED, SM, /*AddrOf*/PP, SourceLocation.getFromRawEncoding(CommentBegin), Status);
      return false;
    }
    
    std.string C2/*J*/= new std.string();
    C2.reserve(C.size());
    
    for (/*size_t*/int last = 0;; loc = C.find($$BACK_SLASH, last)) {
      if (loc == StringRef.npos || loc == C.size()) {
        $addassign_string_StringRef(C2, C.substr(last));
        break;
      }
      $addassign_string_StringRef(C2, C.substr(last, loc - last));
      last = loc + 1;
      if (C.$at(last) == $$LF || C.$at(last) == $$CR) {
        ++last;
        
        // Escape \r\n  or \n\r, but not \n\n.
        if (last < C.size()) {
          if (C.$at(last) == $$LF || C.$at(last) == $$CR) {
            if (C.$at(last) != C.$at(last - 1)) {
              ++last;
            }
          }
        }
      } else {
        // This was just a normal backslash.
        C2.$addassign_T($$BACK_SLASH);
      }
    }
    if (!C2.empty()) {
      ParseDirective(new StringRef(C2), /*AddrOf*/ED, SM, /*AddrOf*/PP, SourceLocation.getFromRawEncoding(CommentBegin), Status);
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VerifyDiagnosticConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 110,
   FQN="clang::VerifyDiagnosticConsumer::HandleDiagnostic", NM="_ZN5clang24VerifyDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang24VerifyDiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    if (Info.hasSourceManager()) {
      // If this diagnostic is for a different source manager, ignore it.
      if ((SrcManager != null) && /*AddrOf*/Info.getSourceManager() != SrcManager) {
        return;
      }
      
      setSourceManager(Info.getSourceManager());
    }
    // Debug build tracks unparsed files for possible
    // unparsed expected-* directives.
    if ((SrcManager != null)) {
      SourceLocation Loc = new SourceLocation(Info.getLocation());
      if (Loc.isValid()) {
        ParsedStatus PS = ParsedStatus.IsUnparsed;
        
        Loc.$assignMove(SrcManager.getExpansionLoc(/*NO_COPY*/Loc));
        FileID FID = SrcManager.getFileID(/*NO_COPY*/Loc);
        
        /*const*/ FileEntry /*P*/ FE = SrcManager.getFileEntryForID(/*NO_COPY*/FID);
        if ((FE != null) && (CurrentPreprocessor != null) && SrcManager.isLoadedFileID(/*NO_COPY*/FID)) {
          // If the file is a modules header file it shall not be parsed
          // for expected-* directives.
          HeaderSearch /*&*/ HS = CurrentPreprocessor.getHeaderSearchInfo();
          if (HS.findModuleForHeader(FE).$bool()) {
            PS = ParsedStatus.IsUnparsedNoDirectives;
          }
        }
        
        UpdateParsedFileStatus(/*Deref*/SrcManager, new FileID(FID), PS);
      }
    }
    
    // Send the diagnostic to the buffer, we will check it once we reach the end
    // of the source file (or are destructed).
    Buffer.$arrow().HandleDiagnostic(DiagLevel, Info);
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diag=" + Diag // NOI18N*/
              + ", PrimaryClient=" + PrimaryClient // NOI18N
              + ", PrimaryClientOwner=" + PrimaryClientOwner // NOI18N
              + ", Buffer=" + Buffer // NOI18N
            /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", CurrentPreprocessor=" + CurrentPreprocessor // NOI18N*/
              + ", LangOpts=" + LangOpts // NOI18N
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", ActiveSourceFiles=" + ActiveSourceFiles // NOI18N
              + ", Status=" + Status.$deref() // NOI18N
              + ", ED=" + ED // NOI18N
              + ", ParsedFiles=" + ParsedFiles // NOI18N
              + ", UnparsedFiles=" + UnparsedFiles // NOI18N
              + super.toString(); // NOI18N
  }
}
