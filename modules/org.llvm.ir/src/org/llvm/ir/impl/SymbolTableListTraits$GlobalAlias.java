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

package org.llvm.ir.impl;

import org.clank.support.Converted;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.NativeTrace;
import org.llvm.adt.ilist_nextprev_traits;
import org.llvm.adt.ilist_node_traits;
import org.llvm.adt.iplist;
import org.llvm.ir.GlobalAlias;
import org.llvm.ir.Module;
import org.llvm.ir.SymbolTableList;
import org.llvm.ir.SymbolTableListTraits;
import org.llvm.ir.ValueSymbolTable;

//<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 44,
 FQN="llvm::SymbolTableListTraits<GlobalAlias>", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEEE")
//</editor-fold>
public class SymbolTableListTraits$GlobalAlias implements /*public*/ SymbolTableListTraits<GlobalAlias, Module>, /*public*/ ilist_nextprev_traits<GlobalAlias>, /*public*/ ilist_node_traits<GlobalAlias> {
// JAVA: typedef SymbolTableList<GlobalAlias> ListTy
//  public final class ListTy extends SymbolTableList<GlobalAlias, Module>{ };
  // JAVA: typedef typename SymbolTableListParentType<GlobalAlias>::type ItemParentClass
//  public final class ItemParentClass extends Module{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::SymbolTableListTraits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 80,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::SymbolTableListTraits", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEEC1Ev")
  //</editor-fold>
  public SymbolTableListTraits$GlobalAlias() {
    // : ilist_nextprev_traits<GlobalAlias>(), SymbolTableListSentinelTraits<GlobalAlias>(), ilist_node_traits<GlobalAlias>()
    super();
    $ilist_default_traits();
    //super();
    //super();
  }

  /*private:*/
  /// getListOwner - Return the object that owns this list.  If this is a list
  /// of instructions, it returns the BasicBlock that owns them.
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::getListOwner">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 85,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::getListOwner", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE12getListOwnerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE12getListOwnerEv")
  //</editor-fold>
  public Module getListOwner( /*typename*/ /*P*/ iplist<GlobalAlias> list) {
    assert list instanceof SymbolTableList$GlobalAlias : "forgot to pass valid list object?" + NativeTrace.getIdentityStr(list);
    return ((SymbolTableList$GlobalAlias) list).getListOwner(list);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::getList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 93,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::getList", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE7getListEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE7getListEPNS_6ModuleE")
  //</editor-fold>
  public SymbolTableList<GlobalAlias, Module>/*&*/ getList(Module /*P*/ Par) {
    // return Par ->* (Par.getSublistAccess((GlobalAlias /*P*/ )(GlobalAlias /*P*/ )null));
    return /*P*/ Par.getSublistAccess((GlobalAlias) null).$call(Par);
  }

  //private:
  /*template <typename TPtr> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::setSymTabObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 109,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::setSymTabObject", NM="Tpl__ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE15setSymTabObjectEPT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=Tpl__ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE15setSymTabObjectEPT_S3_")
  //</editor-fold>
  public </*typename*/ TPtr> void setSymTabObject(TPtr /*P*/ $Prm0, TPtr $Prm1) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 110,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::toPtr", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE5toPtrEPNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE5toPtrEPNS_16ValueSymbolTableE")
  //</editor-fold>
  public static ValueSymbolTable /*P*/ toPtr_ValueSymbolTable$P(ValueSymbolTable /*P*/ P) {
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalAlias>::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 111,
   FQN="llvm::SymbolTableListTraits<GlobalAlias>::toPtr", NM="_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE5toPtrERNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_11GlobalAliasEE5toPtrERNS_16ValueSymbolTableE")
  //</editor-fold>
  public static ValueSymbolTable /*P*/ toPtr_ValueSymbolTable(final ValueSymbolTable /*&*/ R) {
    return $AddrOf(R);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final GlobalAlias $sentinelField = GlobalAlias.createSentinel();

  @Override
  public GlobalAlias $SentinelField() {
    return $sentinelField;
  }

  @Override
  public Class<GlobalAlias> $getValueSubClass() {
    return GlobalAlias.class;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class SymbolTableList$GlobalAlias extends SymbolTableList<GlobalAlias, Module> {

    public SymbolTableList$GlobalAlias(Module/*P*/ Owner) {
      super(Owner);
    }
    
    @Override
    public GlobalAlias $SentinelField() {
      return (GlobalAlias)((SymbolTableListTraits)super.$traits()).$SentinelField();
    }
    
    @Override
    protected SymbolTableListTraits$GlobalAlias $createTraits() {
      return new SymbolTableListTraits$GlobalAlias();
    }
    
    @Override
    public Class<GlobalAlias> $getValueSubClass() {
      return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
    }
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
    
}
