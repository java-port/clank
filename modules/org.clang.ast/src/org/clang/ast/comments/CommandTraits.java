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

package org.clang.ast.comments;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.comments.CommentsGlobals.Commands; 

/// This class provides information about commands that can be used
/// in comments.
//<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 128,
 FQN="clang::comments::CommandTraits", NM="_ZN5clang8comments13CommandTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8comments13CommandTraitsE")
//</editor-fold>
public class CommandTraits implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::KnownCommandIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 130,
   FQN="clang::comments::CommandTraits::KnownCommandIDs", NM="_ZN5clang8comments13CommandTraits15KnownCommandIDsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8comments13CommandTraits15KnownCommandIDsE")
  //</editor-fold>
  public enum KnownCommandIDs implements Native.ComparableLower {
    KCI_a(0),
    KCI_abstract(KCI_a.getValue() + 1),
    KCI_addtogroup(KCI_abstract.getValue() + 1),
    KCI_arg(KCI_addtogroup.getValue() + 1),
    KCI_attention(KCI_arg.getValue() + 1),
    KCI_author(KCI_attention.getValue() + 1),
    KCI_authors(KCI_author.getValue() + 1),
    KCI_b(KCI_authors.getValue() + 1),
    KCI_brief(KCI_b.getValue() + 1),
    KCI_bug(KCI_brief.getValue() + 1),
    KCI_c(KCI_bug.getValue() + 1),
    KCI_callback(KCI_c.getValue() + 1),
    KCI_category(KCI_callback.getValue() + 1),
    KCI_class(KCI_category.getValue() + 1),
    KCI_classdesign(KCI_class.getValue() + 1),
    KCI_coclass(KCI_classdesign.getValue() + 1),
    KCI_code(KCI_coclass.getValue() + 1),
    KCI_endcode(KCI_code.getValue() + 1),
    KCI_const(KCI_endcode.getValue() + 1),
    KCI_constant(KCI_const.getValue() + 1),
    KCI_copyright(KCI_constant.getValue() + 1),
    KCI_date(KCI_copyright.getValue() + 1),
    KCI_def(KCI_date.getValue() + 1),
    KCI_defgroup(KCI_def.getValue() + 1),
    KCI_dependency(KCI_defgroup.getValue() + 1),
    KCI_deprecated(KCI_dependency.getValue() + 1),
    KCI_details(KCI_deprecated.getValue() + 1),
    KCI_discussion(KCI_details.getValue() + 1),
    KCI_dot(KCI_discussion.getValue() + 1),
    KCI_enddot(KCI_dot.getValue() + 1),
    KCI_e(KCI_enddot.getValue() + 1),
    KCI_em(KCI_e.getValue() + 1),
    KCI_enum(KCI_em.getValue() + 1),
    KCI_exception(KCI_enum.getValue() + 1),
    KCI_flbrace(KCI_exception.getValue() + 1),
    KCI_frbrace(KCI_flbrace.getValue() + 1),
    KCI_flsquare(KCI_frbrace.getValue() + 1),
    KCI_frsquare(KCI_flsquare.getValue() + 1),
    KCI_fdollar(KCI_frsquare.getValue() + 1),
    KCI_fn(KCI_fdollar.getValue() + 1),
    KCI_function(KCI_fn.getValue() + 1),
    KCI_functiongroup(KCI_function.getValue() + 1),
    KCI_headerfile(KCI_functiongroup.getValue() + 1),
    KCI_helper(KCI_headerfile.getValue() + 1),
    KCI_helperclass(KCI_helper.getValue() + 1),
    KCI_helps(KCI_helperclass.getValue() + 1),
    KCI_htmlonly(KCI_helps.getValue() + 1),
    KCI_endhtmlonly(KCI_htmlonly.getValue() + 1),
    KCI_ingroup(KCI_endhtmlonly.getValue() + 1),
    KCI_instancesize(KCI_ingroup.getValue() + 1),
    KCI_interface(KCI_instancesize.getValue() + 1),
    KCI_invariant(KCI_interface.getValue() + 1),
    KCI_latexonly(KCI_invariant.getValue() + 1),
    KCI_endlatexonly(KCI_latexonly.getValue() + 1),
    KCI_li(KCI_endlatexonly.getValue() + 1),
    KCI_link(KCI_li.getValue() + 1),
    KCI_slashlink(KCI_link.getValue() + 1),
    KCI_mainpage(KCI_slashlink.getValue() + 1),
    KCI_manonly(KCI_mainpage.getValue() + 1),
    KCI_endmanonly(KCI_manonly.getValue() + 1),
    KCI_method(KCI_endmanonly.getValue() + 1),
    KCI_methodgroup(KCI_method.getValue() + 1),
    KCI_msc(KCI_methodgroup.getValue() + 1),
    KCI_endmsc(KCI_msc.getValue() + 1),
    KCI_name(KCI_endmsc.getValue() + 1),
    KCI_namespace(KCI_name.getValue() + 1),
    KCI_note(KCI_namespace.getValue() + 1),
    KCI_overload(KCI_note.getValue() + 1),
    KCI_ownership(KCI_overload.getValue() + 1),
    KCI_p(KCI_ownership.getValue() + 1),
    KCI_par(KCI_p.getValue() + 1),
    KCI_paragraph(KCI_par.getValue() + 1),
    KCI_param(KCI_paragraph.getValue() + 1),
    KCI_performance(KCI_param.getValue() + 1),
    KCI_post(KCI_performance.getValue() + 1),
    KCI_pre(KCI_post.getValue() + 1),
    KCI_property(KCI_pre.getValue() + 1),
    KCI_protocol(KCI_property.getValue() + 1),
    KCI_ref(KCI_protocol.getValue() + 1),
    KCI_related(KCI_ref.getValue() + 1),
    KCI_relatedalso(KCI_related.getValue() + 1),
    KCI_relates(KCI_relatedalso.getValue() + 1),
    KCI_relatesalso(KCI_relates.getValue() + 1),
    KCI_remark(KCI_relatesalso.getValue() + 1),
    KCI_remarks(KCI_remark.getValue() + 1),
    KCI_result(KCI_remarks.getValue() + 1),
    KCI_return(KCI_result.getValue() + 1),
    KCI_returns(KCI_return.getValue() + 1),
    KCI_rtfonly(KCI_returns.getValue() + 1),
    KCI_endrtfonly(KCI_rtfonly.getValue() + 1),
    KCI_sa(KCI_endrtfonly.getValue() + 1),
    KCI_section(KCI_sa.getValue() + 1),
    KCI_security(KCI_section.getValue() + 1),
    KCI_see(KCI_security.getValue() + 1),
    KCI_seealso(KCI_see.getValue() + 1),
    KCI_short(KCI_seealso.getValue() + 1),
    KCI_since(KCI_short.getValue() + 1),
    KCI_struct(KCI_since.getValue() + 1),
    KCI_subpage(KCI_struct.getValue() + 1),
    KCI_subsection(KCI_subpage.getValue() + 1),
    KCI_subsubsection(KCI_subsection.getValue() + 1),
    KCI_superclass(KCI_subsubsection.getValue() + 1),
    KCI_template(KCI_superclass.getValue() + 1),
    KCI_templatefield(KCI_template.getValue() + 1),
    KCI_textblock(KCI_templatefield.getValue() + 1),
    KCI_slashtextblock(KCI_textblock.getValue() + 1),
    KCI_throw(KCI_slashtextblock.getValue() + 1),
    KCI_throws(KCI_throw.getValue() + 1),
    KCI_todo(KCI_throws.getValue() + 1),
    KCI_tparam(KCI_todo.getValue() + 1),
    KCI_typedef(KCI_tparam.getValue() + 1),
    KCI_union(KCI_typedef.getValue() + 1),
    KCI_var(KCI_union.getValue() + 1),
    KCI_verbatim(KCI_var.getValue() + 1),
    KCI_endverbatim(KCI_verbatim.getValue() + 1),
    KCI_version(KCI_endverbatim.getValue() + 1),
    KCI_warning(KCI_version.getValue() + 1),
    KCI_weakgroup(KCI_warning.getValue() + 1),
    KCI_xmlonly(KCI_weakgroup.getValue() + 1),
    KCI_endxmlonly(KCI_xmlonly.getValue() + 1),
    KCI_Last(KCI_endxmlonly.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static KnownCommandIDs valueOf(int val) {
      KnownCommandIDs out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final KnownCommandIDs[] VALUES;
      private static final KnownCommandIDs[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (KnownCommandIDs kind : KnownCommandIDs.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new KnownCommandIDs[min < 0 ? (1-min) : 0];
        VALUES = new KnownCommandIDs[max >= 0 ? (1+max) : 0];
        for (KnownCommandIDs kind : KnownCommandIDs.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private KnownCommandIDs(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((KnownCommandIDs)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((KnownCommandIDs)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::CommandTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 18,
   FQN="clang::comments::CommandTraits::CommandTraits", NM="_ZN5clang8comments13CommandTraitsC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERKNS_14CommentOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraitsC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERKNS_14CommentOptionsE")
  //</editor-fold>
  public CommandTraits(final BumpPtrAllocatorImpl /*&*/ Allocator, 
      final /*const*/ CommentOptions /*&*/ CommentOptions) {
    // : NextID(llvm::array_lengthof(Commands)), Allocator(Allocator), RegisteredCommands() 
    //START JInit
    this.NextID = llvm.array_lengthof(Commands);
    this./*&*/Allocator=/*&*/Allocator;
    this.RegisteredCommands = new SmallVector<CommandInfo /*P*/ >(4, (CommandInfo /*P*/ )null);
    //END JInit
    registerCommentOptions(CommentOptions);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::registerCommentOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 24,
   FQN="clang::comments::CommandTraits::registerCommentOptions", NM="_ZN5clang8comments13CommandTraits22registerCommentOptionsERKNS_14CommentOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits22registerCommentOptionsERKNS_14CommentOptionsE")
  //</editor-fold>
  public void registerCommentOptions(final /*const*/ CommentOptions /*&*/ CommentOptions) {
    std.vectorString.iterator begin$Const = CommentOptions.BlockCommandNames.begin$Const();
    for (std.vectorString.iterator I = CommentOptions.BlockCommandNames.begin$Const(), 
        E = CommentOptions.BlockCommandNames.end$Const();
         $noteq___normal_iterator$C(I, E); I.$postInc()) {
      registerBlockCommand(new StringRef(I.$star()));
    }
  }


  
  /// \returns a CommandInfo object for a given command name or
  /// NULL if no CommandInfo object exists for this command.
  
  /// \returns a CommandInfo object for a given command name or
  /// NULL if no CommandInfo object exists for this command.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getCommandInfoOrNULL">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 34,
   FQN="clang::comments::CommandTraits::getCommandInfoOrNULL", NM="_ZNK5clang8comments13CommandTraits20getCommandInfoOrNULLEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments13CommandTraits20getCommandInfoOrNULLEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ getCommandInfoOrNULL(StringRef Name) /*const*/ {
    {
      /*const*/ CommandInfo /*P*/ Info = getBuiltinCommandInfo(new StringRef(Name));
      if ((Info != null)) {
        return Info;
      }
    }
    return getRegisteredCommandInfo(new StringRef(Name));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 146,
   FQN="clang::comments::CommandTraits::getCommandInfo", NM="_ZNK5clang8comments13CommandTraits14getCommandInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang8comments13CommandTraits14getCommandInfoEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ getCommandInfo(StringRef Name) /*const*/ {
    {
      /*const*/ CommandInfo /*P*/ Info = getCommandInfoOrNULL(new StringRef(Name));
      if ((Info != null)) {
        return Info;
      }
    }
    throw new llvm_unreachable("the command should be known");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getTypoCorrectCommandInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 46,
   FQN="clang::comments::CommandTraits::getTypoCorrectCommandInfo", NM="_ZNK5clang8comments13CommandTraits25getTypoCorrectCommandInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments13CommandTraits25getTypoCorrectCommandInfoEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ getTypoCorrectCommandInfo(StringRef Typo) /*const*/ {
    // Single-character command impostures, such as \t or \n, should not go
    // through the fixit logic.
    if ($lesseq_uint(Typo.size(), 1)) {
      return null;
    }
    
    // The maximum edit distance we're prepared to accept.
    /*const*//*uint*/int MaxEditDistance = 1;
    
    final /*uint*/uint$ref BestEditDistance = create_uint$ref(MaxEditDistance);
    SmallVector</*const*/ CommandInfo /*P*/ > BestCommand/*J*/= new SmallVector</*const*/ CommandInfo /*P*/ >(2, (/*const*/ CommandInfo /*P*/ )null);
    
    CommandInfo$P2Void ConsiderCorrection =  /*[&]*/(/*const*/ CommandInfo /*P*/ Command) -> 
      {
        StringRef Name = new StringRef(Command.Name);
        
        /*uint*/int MinPossibleEditDistance = std.abs((int)Name.size() - (int)Typo.size());
        if ($lesseq_uint(MinPossibleEditDistance, BestEditDistance)) {
          /*uint*/int EditDistance = Typo.edit_distance(/*NO_COPY*/Name, /*KEEP_BOOL*/true, BestEditDistance.$deref());
          if ($less_uint(EditDistance, BestEditDistance)) {
            BestEditDistance.$set(EditDistance);
            BestCommand.clear();
          }
          if (EditDistance == BestEditDistance.$deref()) {
            BestCommand.push_back(Command);
          }
        }
      }
  ;
    
    for (final /*const*/ CommandInfo /*&*/ Command : Commands)  {
      ConsiderCorrection.$call($AddrOf(Command));
    }
    
    for (/*const*/ CommandInfo /*P*/ Command : RegisteredCommands)  {
      if (!Command.IsUnknownCommand) {
        ConsiderCorrection.$call(Command);
      }
    }
    
    return BestCommand.size() == 1 ? BestCommand.$at(0) : null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 40,
   FQN="clang::comments::CommandTraits::getCommandInfo", NM="_ZNK5clang8comments13CommandTraits14getCommandInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments13CommandTraits14getCommandInfoEj")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ getCommandInfo(/*uint*/int CommandID) /*const*/ {
    {
      /*const*/ CommandInfo /*P*/ Info = getBuiltinCommandInfo(CommandID);
      if ((Info != null)) {
        return Info;
      }
    }
    return getRegisteredCommandInfo(CommandID);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::registerUnknownCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 103,
   FQN="clang::comments::CommandTraits::registerUnknownCommand", NM="_ZN5clang8comments13CommandTraits22registerUnknownCommandEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits22registerUnknownCommandEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ registerUnknownCommand(StringRef CommandName) {
    CommandInfo /*P*/ Info = createCommandInfoWithName(new StringRef(CommandName));
    Info.IsUnknownCommand = true;
    return Info;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::registerBlockCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 110,
   FQN="clang::comments::CommandTraits::registerBlockCommand", NM="_ZN5clang8comments13CommandTraits20registerBlockCommandEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits20registerBlockCommandEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ CommandInfo /*P*/ registerBlockCommand(StringRef CommandName) {
    CommandInfo /*P*/ Info = createCommandInfoWithName(new StringRef(CommandName));
    Info.IsBlockCommand = true;
    return Info;
  }


  
  /// \returns a CommandInfo object for a given command name or
  /// NULL if \c Name is not a builtin command.
  
  /// \returns a CommandInfo object for a given command name or
  /// NULL if \c Name is not a builtin command.
  // unnamed namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getBuiltinCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentCommandInfo.inc", line = 134,
   FQN="clang::comments::CommandTraits::getBuiltinCommandInfo", NM="_ZN5clang8comments13CommandTraits21getBuiltinCommandInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits21getBuiltinCommandInfoEN4llvm9StringRefE")
  //</editor-fold>
  public static /*const*/ CommandInfo /*P*/ getBuiltinCommandInfo(StringRef Name) {
    switch (Name.size()) {
     default:
      break;
     case 1: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        return $AddrOf(Commands[0]); // "a"
       case 'b': // 1 string to match.
        return $AddrOf(Commands[7]); // "b"
       case 'c': // 1 string to match.
        return $AddrOf(Commands[10]); // "c"
       case 'e': // 1 string to match.
        return $AddrOf(Commands[30]); // "e"
       case 'p': // 1 string to match.
        return $AddrOf(Commands[69]); // "p"
      }
      break;
     case 2: // 9 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'e': // 1 string to match.
        if (Name.$at(1) != $$m) {
          break;
        }
        return $AddrOf(Commands[31]); // "em"
       case 'f': // 6 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case '$': // 1 string to match.
          return $AddrOf(Commands[38]); // "f$"
         case '[': // 1 string to match.
          return $AddrOf(Commands[36]); // "f["
         case ']': // 1 string to match.
          return $AddrOf(Commands[37]); // "f]"
         case 'n': // 1 string to match.
          return $AddrOf(Commands[39]); // "fn"
         case '{': // 1 string to match.
          return $AddrOf(Commands[34]); // "f{"
         case '}': // 1 string to match.
          return $AddrOf(Commands[35]); // "f}"
        }
        break;
       case 'l': // 1 string to match.
        if (Name.$at(1) != $$i) {
          break;
        }
        return $AddrOf(Commands[54]); // "li"
       case 's': // 1 string to match.
        if (Name.$at(1) != $$a) {
          break;
        }
        return $AddrOf(Commands[90]); // "sa"
      }
      break;
     case 3: // 10 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("rg"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[3]); // "arg"
       case 'b': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ug"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[9]); // "bug"
       case 'd': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if (Name.$at(2) != $$f) {
            break;
          }
          return $AddrOf(Commands[22]); // "def"
         case 'o': // 1 string to match.
          if (Name.$at(2) != $$t) {
            break;
          }
          return $AddrOf(Commands[28]); // "dot"
        }
        break;
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("sc"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[62]); // "msc"
       case 'p': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if (Name.$at(2) != $$r) {
            break;
          }
          return $AddrOf(Commands[70]); // "par"
         case 'r': // 1 string to match.
          if (Name.$at(2) != $$e) {
            break;
          }
          return $AddrOf(Commands[75]); // "pre"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ef"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[78]); // "ref"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ee"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[93]); // "see"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ar"), 2) != 0)) {
          break;
        }
        return $AddrOf(Commands[112]); // "var"
      }
      break;
     case 4: // 8 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ode"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[16]); // "code"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ate"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[21]); // "date"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("num"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[32]); // "enum"
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ink"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[55]); // "link"
       case 'n': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("me"), 2) != 0)) {
            break;
          }
          return $AddrOf(Commands[64]); // "name"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("te"), 2) != 0)) {
            break;
          }
          return $AddrOf(Commands[66]); // "note"
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ost"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[74]); // "post"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("odo"), 3) != 0)) {
          break;
        }
        return $AddrOf(Commands[108]); // "todo"
      }
      break;
     case 5: // 10 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '/': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("link"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[56]); // "/link"
       case 'b': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("rief"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[8]); // "brief"
       case 'c': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'l': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ass"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[13]); // "class"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nst"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[18]); // "const"
        }
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("elps"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[45]); // "helps"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("aram"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[72]); // "param"
       case 's': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'h': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ort"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[95]); // "short"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nce"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[96]); // "since"
        }
        break;
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hrow"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[106]); // "throw"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nion"), 4) != 0)) {
          break;
        }
        return $AddrOf(Commands[111]); // "union"
      }
      break;
     case 6: // 11 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("uthor"), 5) != 0)) {
          break;
        }
        return $AddrOf(Commands[5]); // "author"
       case 'e': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("nd"), 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'd': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("ot"), 2) != 0)) {
            break;
          }
          return $AddrOf(Commands[29]); // "enddot"
         case 'm': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("sc"), 2) != 0)) {
            break;
          }
          return $AddrOf(Commands[63]); // "endmsc"
        }
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("elper"), 5) != 0)) {
          break;
        }
        return $AddrOf(Commands[43]); // "helper"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ethod"), 5) != 0)) {
          break;
        }
        return $AddrOf(Commands[60]); // "method"
       case 'r': // 3 strings to match.
        if (Name.$at(1) != $$e) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'm': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ark"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[83]); // "remark"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ult"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[85]); // "result"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("urn"), 3) != 0)) {
            break;
          }
          return $AddrOf(Commands[86]); // "return"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("truct"), 5) != 0)) {
          break;
        }
        return $AddrOf(Commands[97]); // "struct"
       case 't': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'h': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("rows"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[107]); // "throws"
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("aram"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[109]); // "tparam"
        }
        break;
      }
      break;
     case 7: // 18 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("uthors"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[6]); // "authors"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("oclass"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[15]); // "coclass"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("etails"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[26]); // "details"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ndcode"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[17]); // "endcode"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ngroup"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[48]); // "ingroup"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("anonly"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[58]); // "manonly"
       case 'r': // 5 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 4 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'l': // 2 strings to match.
            if ((memcmp(Name.data().$add(3), $("ate"), 3) != 0)) {
              break;
            }
            switch (Name.$at(6)) {
             default:
              break;
             case 'd': // 1 string to match.
              return $AddrOf(Commands[79]); // "related"
             case 's': // 1 string to match.
              return $AddrOf(Commands[81]); // "relates"
            }
            break;
           case 'm': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("arks"), 4) != 0)) {
              break;
            }
            return $AddrOf(Commands[84]); // "remarks"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("urns"), 4) != 0)) {
              break;
            }
            return $AddrOf(Commands[87]); // "returns"
          }
          break;
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("fonly"), 5) != 0)) {
            break;
          }
          return $AddrOf(Commands[88]); // "rtfonly"
        }
        break;
       case 's': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 2 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'c': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("tion"), 4) != 0)) {
              break;
            }
            return $AddrOf(Commands[91]); // "section"
           case 'e': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("also"), 4) != 0)) {
              break;
            }
            return $AddrOf(Commands[94]); // "seealso"
          }
          break;
         case 'u': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("bpage"), 5) != 0)) {
            break;
          }
          return $AddrOf(Commands[98]); // "subpage"
        }
        break;
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ypedef"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[110]); // "typedef"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ersion"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[115]); // "version"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("arning"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[116]); // "warning"
       case 'x': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("mlonly"), 6) != 0)) {
          break;
        }
        return $AddrOf(Commands[118]); // "xmlonly"
      }
      break;
     case 8: // 14 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bstract"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[1]); // "abstract"
       case 'c': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 2 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'l': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("lback"), 5) != 0)) {
              break;
            }
            return $AddrOf(Commands[11]); // "callback"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("egory"), 5) != 0)) {
              break;
            }
            return $AddrOf(Commands[12]); // "category"
          }
          break;
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nstant"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[19]); // "constant"
        }
        break;
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("efgroup"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[23]); // "defgroup"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("unction"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[40]); // "function"
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("tmlonly"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[46]); // "htmlonly"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ainpage"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[57]); // "mainpage"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("verload"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[67]); // "overload"
       case 'p': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("ro"), 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("erty"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[76]); // "property"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("ocol"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[77]); // "protocol"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ecurity"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[92]); // "security"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("emplate"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[102]); // "template"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("erbatim"), 7) != 0)) {
          break;
        }
        return $AddrOf(Commands[113]); // "verbatim"
      }
      break;
     case 9: // 11 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ttention"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[4]); // "attention"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("opyright"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[20]); // "copyright"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("xception"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[33]); // "exception"
       case 'i': // 2 strings to match.
        if (Name.$at(1) != $$n) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("erface"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[50]); // "interface"
         case 'v': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ariant"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[51]); // "invariant"
        }
        break;
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("atexonly"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[52]); // "latexonly"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("amespace"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[65]); // "namespace"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("wnership"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[68]); // "ownership"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("aragraph"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[71]); // "paragraph"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("extblock"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[104]); // "textblock"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eakgroup"), 8) != 0)) {
          break;
        }
        return $AddrOf(Commands[117]); // "weakgroup"
      }
      break;
     case 10: // 11 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '/': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("textblock"), 9) != 0)) {
          break;
        }
        return $AddrOf(Commands[105]); // "/textblock"
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ddtogroup"), 9) != 0)) {
          break;
        }
        return $AddrOf(Commands[2]); // "addtogroup"
       case 'd': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 2 strings to match.
          if (Name.$at(2) != $$p) {
            break;
          }
          switch (Name.$at(3)) {
           default:
            break;
           case 'e': // 1 string to match.
            if ((memcmp(Name.data().$add(4), $("ndency"), 6) != 0)) {
              break;
            }
            return $AddrOf(Commands[24]); // "dependency"
           case 'r': // 1 string to match.
            if ((memcmp(Name.data().$add(4), $("ecated"), 6) != 0)) {
              break;
            }
            return $AddrOf(Commands[25]); // "deprecated"
          }
          break;
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("scussion"), 8) != 0)) {
            break;
          }
          return $AddrOf(Commands[27]); // "discussion"
        }
        break;
       case 'e': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("nd"), 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'm': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("anonly"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[59]); // "endmanonly"
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("tfonly"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[89]); // "endrtfonly"
         case 'x': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("mlonly"), 6) != 0)) {
            break;
          }
          return $AddrOf(Commands[119]); // "endxmlonly"
        }
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eaderfile"), 9) != 0)) {
          break;
        }
        return $AddrOf(Commands[42]); // "headerfile"
       case 's': // 2 strings to match.
        if (Name.$at(1) != $$u) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("section"), 7) != 0)) {
            break;
          }
          return $AddrOf(Commands[99]); // "subsection"
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("erclass"), 7) != 0)) {
            break;
          }
          return $AddrOf(Commands[101]); // "superclass"
        }
        break;
      }
      break;
     case 11: // 8 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lassdesign"), 10) != 0)) {
          break;
        }
        return $AddrOf(Commands[14]); // "classdesign"
       case 'e': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("nd"), 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'h': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("tmlonly"), 7) != 0)) {
            break;
          }
          return $AddrOf(Commands[47]); // "endhtmlonly"
         case 'v': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("erbatim"), 7) != 0)) {
            break;
          }
          return $AddrOf(Commands[114]); // "endverbatim"
        }
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("elperclass"), 10) != 0)) {
          break;
        }
        return $AddrOf(Commands[44]); // "helperclass"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ethodgroup"), 10) != 0)) {
          break;
        }
        return $AddrOf(Commands[61]); // "methodgroup"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("erformance"), 10) != 0)) {
          break;
        }
        return $AddrOf(Commands[73]); // "performance"
       case 'r': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("elate"), 5) != 0)) {
          break;
        }
        switch (Name.$at(6)) {
         default:
          break;
         case 'd': // 1 string to match.
          if ((memcmp(Name.data().$add(7), $("also"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[80]); // "relatedalso"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(7), $("also"), 4) != 0)) {
            break;
          }
          return $AddrOf(Commands[82]); // "relatesalso"
        }
        break;
      }
      break;
     case 12: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ndlatexonly"), 11) != 0)) {
          break;
        }
        return $AddrOf(Commands[53]); // "endlatexonly"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nstancesize"), 11) != 0)) {
          break;
        }
        return $AddrOf(Commands[49]); // "instancesize"
      }
      break;
     case 13: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("unctiongroup"), 12) != 0)) {
          break;
        }
        return $AddrOf(Commands[41]); // "functiongroup"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ubsubsection"), 12) != 0)) {
          break;
        }
        return $AddrOf(Commands[100]); // "subsubsection"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("emplatefield"), 12) != 0)) {
          break;
        }
        return $AddrOf(Commands[103]); // "templatefield"
      }
      break;
    }
    return null;
  }


  
  /// \returns a CommandInfo object for a given command ID or
  /// NULL if \c CommandID is not a builtin command.
  
  /// \returns a CommandInfo object for a given command ID or
  /// NULL if \c CommandID is not a builtin command.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getBuiltinCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 116,
   FQN="clang::comments::CommandTraits::getBuiltinCommandInfo", NM="_ZN5clang8comments13CommandTraits21getBuiltinCommandInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits21getBuiltinCommandInfoEj")
  //</editor-fold>
  public static /*const*/ CommandInfo /*P*/ getBuiltinCommandInfo(/*uint*/int CommandID) {
    if ($less_uint(CommandID, llvm.array_lengthof(Commands))) {
      return $AddrOf(Commands[CommandID]);
    }
    return null;
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::CommandTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 169,
   FQN="clang::comments::CommandTraits::CommandTraits", NM="_ZN5clang8comments13CommandTraitsC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8comments13CommandTraitsC1ERKS1_")
  //</editor-fold>
  private CommandTraits(final /*const*/ CommandTraits /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 170,
   FQN="clang::comments::CommandTraits::operator=", NM="_ZN5clang8comments13CommandTraitsaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8comments13CommandTraitsaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ CommandTraits /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getRegisteredCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 123,
   FQN="clang::comments::CommandTraits::getRegisteredCommandInfo", NM="_ZNK5clang8comments13CommandTraits24getRegisteredCommandInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments13CommandTraits24getRegisteredCommandInfoEN4llvm9StringRefE")
  //</editor-fold>
  private /*const*/ CommandInfo /*P*/ getRegisteredCommandInfo(StringRef Name) /*const*/ {
    for (/*uint*/int i = 0, e = RegisteredCommands.size(); i != e; ++i) {
      if ($eq_StringRef(/*STRINGREF_STR*/RegisteredCommands.$at$Const(i).Name, /*NO_COPY*/Name)) {
        return RegisteredCommands.$at$Const(i);
      }
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::getRegisteredCommandInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 132,
   FQN="clang::comments::CommandTraits::getRegisteredCommandInfo", NM="_ZNK5clang8comments13CommandTraits24getRegisteredCommandInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments13CommandTraits24getRegisteredCommandInfoEj")
  //</editor-fold>
  private /*const*/ CommandInfo /*P*/ getRegisteredCommandInfo(/*uint*/int CommandID) /*const*/ {
    return RegisteredCommands.$at$Const(CommandID - llvm.array_lengthof(Commands));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::createCommandInfoWithName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp", line = 84,
   FQN="clang::comments::CommandTraits::createCommandInfoWithName", NM="_ZN5clang8comments13CommandTraits25createCommandInfoWithNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments13CommandTraits25createCommandInfoWithNameEN4llvm9StringRefE")
  //</editor-fold>
  private CommandInfo /*P*/ createCommandInfoWithName(StringRef CommandName) {
    char$ptr/*char P*/ Name = $tryClone(Allocator./*<charbyte>*/Allocate(CommandName.size() + 1,1));
    memcpy(Name, CommandName.data(), CommandName.size());
    Name.$set(CommandName.size(), $$TERM);
    
    // Value-initialize (=zero-initialize in this case) a new CommandInfo.
    CommandInfo /*P*/ Info = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new CommandInfo();
    Info.Name = $tryClone(Name);
    // We only have a limited number of bits to encode command IDs in the
    // CommandInfo structure, so the ID numbers can potentially wrap around.
    assert (($less_uint(NextID, (1 << CommandInfo.NumCommandIDBits)))) : "Too many commands. We have limited bits for the command ID.";
    Info.ID = NextID++;
    
    RegisteredCommands.push_back(Info);
    
    return Info;
  }


  
  private /*uint*/int NextID;
  
  /// Allocator for CommandInfo objects.
  private final BumpPtrAllocatorImpl /*&*/ Allocator;
  
  private SmallVector<CommandInfo /*P*/ > RegisteredCommands;
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandTraits::~CommandTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 128,
   FQN="clang::comments::CommandTraits::~CommandTraits", NM="_ZN5clang8comments13CommandTraitsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8comments13CommandTraitsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    RegisteredCommands.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "NextID=" + NextID // NOI18N
              + ", Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", RegisteredCommands=" + RegisteredCommands; // NOI18N
  }
}
